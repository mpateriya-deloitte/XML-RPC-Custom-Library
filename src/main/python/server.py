#Import Required Libraries
from xmlrpc.server import SimpleXMLRPCServer
from xmlrpc.server import SimpleXMLRPCRequestHandler

#Create a Class to handle Requests
class RequestHandler(SimpleXMLRPCRequestHandler):
    rpc_paths = ('/xmlrpc',)

#Create a Simple Server on localhost 8080 and use the Request Handler to handle request at specific URL
server = SimpleXMLRPCServer(("localhost", 8080),requestHandler=RequestHandler)

# Creating the Class whose functions will be used in Java
class MyFuncs:
    def add(self, x, y):
        return x + y
    def mul(self, x, y):
        return x * y

#Registering the Class instance and Passing through server
server.register_instance(MyFuncs())

# Run the server's main loop
server.serve_forever()