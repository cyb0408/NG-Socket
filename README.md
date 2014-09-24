NG-Socket
=========

网络游戏服务器通信框架
网络协议 
-----------------------------------  
协议格式详细可以查看doc目录下对应的com.ace.ng.codec.encrypt.EncryptDecoder类的注释。
网络消息解码性能本质性的提升
-----------------------------------
大多网络消息层的处理为了面向对象，会使用反射技术。但是，反射技术相对来说性能会比较低,在大规模并发环境下解码性能也是很关键的一步。NG-Socket的解码层采用Javassit动态更改代码，并且使用缓存等方法大大优化解码性能。
同时在CustomBuf中封装了各种常见的解码接口，方便开发者使用。详情见API 文档。
线程模型
-----------------------------------
###
业务线程模型与Netty框架层的线程分离，互不干扰,依赖于我的另一个项目Game-Current。在本项目中,确保业务逻辑线程池不会对网络通信数据读取以及解码造成影响，提高并发度。
Netty本身是每个Socket连接对应一个线程，同一个客户端的请求数据更改就不会出现线程安全方面的问题。Game-Current依然支持此模型，只是更进一层，你可以针对业务进行扩展，比如副本，每个副本中分配一个TaskSubmiter,
在需要考虑线程安全的问题，统一使用TaskSubmiter进行任务调度。详细见Game-Current相关文档。
模块扩展
-----------------------------------
想要新增一个系统模块非常简单,继承Extension类就可以了，然后在init方法中注册相关消息处理器。
