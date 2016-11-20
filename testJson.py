import collectd
import json
import urllib2

metrics={}
#URL= "http://localhost:8099/chartData"
URL=''
#metrics['status']="UP:1"
def configer(conf):
	global URL,metrics
	for node in conf.children:
		key = node.key.lower()
		val = node.values[0]
		if key == 'url':
			URL = val
		else:
			metrics[key]=val

def initer():
    collectd.debug('initing stuff')

def reader(input_data=None):
    global URL
    values={}
    values=get_json_from_url(URL)
    for key in values:
        metric = collectd.Values();
    	metric.plugin = 'python_plugin_json'
    	metric.type = 'gauge'
	metric.interval = 30
	metric.type_instance = key
    	metric.values = [values[key]]
    	metric.host = 'OverwritenHostname'
    	metric.dispatch()

def get_json_from_url(url):

    global metrics
    for key in metrics:
        data=json.load(urllib2.urlopen(url))
        fields=key.split("/")
        for field in fields:
	    data=data[field]			
	    value=data
	print value
	if len(metrics[key]) == 0:
		metrics[key]=value
	else:
		rules=metrics[key].split(",")
		for rule in rules:
	    		lst=rule.split(":")
	    		if value == lst[0]:
	        		metrics[key]=lst[1]
	        		break
	
	
    print metrics
    return metrics

collectd.register_config(configer)
collectd.register_init(initer)
collectd.register_read(reader)
