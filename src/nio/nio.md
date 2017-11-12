#### JavaIO
Java IO
在Client/Server模型中，Server往往需要同时处理大量来自Client的访问请求，因此Server端需采用支持高并发访问的架构。一种简单而又直接的解决方案是“one-thread-per-connection”。这是一种基于阻塞式I/O的多线程模型。在该模型中，Server为每个Client连接创建一个处理线程，每个处理线程阻塞式等待可能达到的数据，一旦数据到达，则立即处理请求、返回处理结果并再次进入等待状态。由于每个Client连接有一个单独的处理线程为其服务，因此可保证良好的响应时间。但当系统负载增大（并发请求增多）时，Server端需要的线程数会增加，这将成为系统扩展的瓶颈所在。

#### JavaNIO
Java NIO
Java NIO不但引入了全新的高效的I/O机制，同时引入了基于Reactor设计模式的多路复用异步模式。NIO包中主要包含以下几种抽象数据类型。
* Channel(通道)：NIO把它支持的I/O对象抽象为Channel。它模拟了通信连接，类似于原I/O中的流（Stream），用户可以通过它读取和写入数据。目前已知的实例类有SocketChannel、ServerSocketChannel、DatagramChannel、FileChannel等。
* Buffer(缓冲区)：Buffer是一块连续的内存区域，一般作为Channel收发数据的载体出现。所有数据都通过Buffer对象来处理。
* Selector(选择器)：Selector类提供了监控一个和多个通道当前状态的机制。只要Channel向Selector注册了某种特定的事件，Selector就会监听这些事件是否会发生，一旦发生某个事件，便会通知对应的Channel。使用选择器，借助单一线程，就可对数量庞大的活动I/O通道实施监控和维护。
Java NIO的服务端只需启动一个专门的线程来处理所有的IO事件，这种通信模型是怎么实现的呢？Java NIO采用了双向通道（channel）进行数据传输，而不是单向的流（stream），在通道上可以注册我们感兴趣的事件。一共有以下四种事件：
事件名 对应值
服务端接收客户端连接事件 SelectionKey.OP_ACCEPT(16)
客户端连接服务端事件 SelectionKey.OP_CONNECT(8)
读事件 SelectionKey.OP_READ(1)
写事件 SelectionKey.OP_WRITE(4)
服务端和客户端各自维护一个管理通道的对象，我们称之为selector，该对象能检测一个或多个通道 (channel) 上的事件。我们以服务端为例，如果服务端的selector上注册了读事件，某时刻客户端给服务端发送了一些数据，阻塞I/O这时会调用read()方法阻塞地读取数据，而NIO的服务端会在selector中添加一个读事件。服务端的处理线程会轮询地访问selector，如果访问selector时发现有感兴趣的事件到达，则处理这些事件，如果没有感兴趣的事件到达，则处理线程会一直阻塞直到感兴趣的事件到达为止。下面是Java NIO的通信模型示意图：
从下图中可以看出，当有读或写等任何注册的事件发生时，可以从Selector中获得相应的SelectionKey，同时从 SelectionKey中可以找到发生的事件和该事件所发生的具体的SelectableChannel，以获得客户端发送过来的数据。 使用NIO中非阻塞I/O编写服务器处理程序，大体上可以分为下面三个步骤：
1. 向Selector对象注册感兴趣的事件
2. 从Selector中获取感兴趣的事件
3. 根据不同的事件进行相应的处理

### 1.基本 概念
IO 是主存和外部设备 ( 硬盘、终端和网络等 ) 拷贝数据的过程。 IO 是操作系统的底层功能实现，底层通过 I/O 指令进行完成。
所有语言运行时系统提供执行 I/O 较高级别的工具。 (c 的 printf scanf,java 的面向对象封装 )
### 2.Java 标准 io回顾
Java 标准 IO 类库是 io 面向对象的一种抽象。基于本地方法的底层实现，我们无须关注底层实现。 InputStream\OutputStream( 字节流 ) ：一次传送一个字节。 Reader\Writer( 字符流 ) ：一次一个字符。
### 3.nio简介
nio 是 java New IO 的简称，在 jdk1.4 里提供的新 api 。
Sun 官方标榜的特性如下：
- 为所有的原始类型提供 (Buffer) 缓存支持。
- 字符集编码解码解决方案。
- Channel ：一个新的原始 I/O 抽象。
- 支持锁和内存映射文件的文件访问接口。
- 提供多路 (non-bloking) 非阻塞式的高伸缩性网络 I/O 。

#### 4.Buffer&Chanel
Channel 和 buffer 是 NIO 是两个最基本的数据类型抽象。
Buffer:
- 是一块连续的内存块。
- 是 NIO 数据读或写的中转地。
Channel:
- 数据的源头或者数据的目的地
- 用于向 buffer 提供数据或者读取 buffer 数据 ,buffer 对象的唯一接口。
- 异步 I/O 支持
