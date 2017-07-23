# zuul_test
自建两个服务，Service1和Service2，然后通过zuul进行代理。注意的是配置中stripPrefix的这个属性。代码中注明了它的使用方式。服务1这样访问：http://localhost:8000/service1/hello，服务2这样访问：http://localhost:8000/service2/service2/hello
