import xmlrpc.client
client = xmlrpc.client.ServerProxy('http://localhost:8282/xmlrpc')
print(client.XmlRpcService.getSUM(34,39))
print(client.XmlRpcService.getMessage("Milind"))