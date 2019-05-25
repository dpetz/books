# Project Notes

## May 2019
- use most of [prison-play](https://github.com/dpetz/prison-play/blob/master/doc/Notes.md) tech stack
- includes: Microservice Scala, Play, RESTful, reactive / actor based, Microservices
-  Instead RDBM use ElasticSearch (ES) to include IR. Sorry this implies to drop [Slick].
-  From [Introduction to Play] download [Hello World](https://developer.lightbend.com/start/?group=play)
- At terminal ``brew install elasticsearch`` and run server via ``elasticsearch`` at http://localhost:9200
- Adding [wabisabi] as Scala as ES client (ignore [play-elasticsearch] which seems inactive)
- To call database non-blocking from action add [custom execution context] with  [custom binding] and configure [custom dispatcher] in ``application.conf``


[Slick]:http://slick.lightbend.com/
[Introduction to Play]: https://www.playframework.com/documentation/2.6.21/HelloWorldTutorial
[wabisabi]:https://github.com/gphat/wabisabi
[play-elasticsearch]: https://index.scala-lang.org/enalmada/play-elasticsearch/play-elasticsearch/0.1.5?target=_2.11
[custom dispatcher]: https://www.playframework.com/documentation/2.6.x/ThreadPools
[custom binding]: https://www.playframework.com/documentation/2.7.x/ScalaDependencyInjection#Binding-annotations
[custom execution context]: https://www.playframework.com/documentation/2.7.x/ScalaAsync#Creating-non-blocking-actions