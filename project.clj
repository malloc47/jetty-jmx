(defproject jetty-jmx "0.1.0-SNAPSHOT"
  :description "Example jetty ring server that exposes JMX"
  :url "https://github.com/malloc47/jetty-jmx"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring/ring-core "1.3.2"]
                 [info.sunng/ring-jetty9-adapter "0.8.1"]
                 [org.eclipse.jetty/jetty-jmx "9.2.7.v20150116"]]
  :jvm-opts ["-Dcom.sun.management.jmxremote"
             "-Dcom.sun.management.jmxremote.ssl=false"
             "-Dcom.sun.management.jmxremote.authenticate=false"
             "-Dcom.sun.management.jmxremote.port=8001"]
  :main ^:skip-aot jetty-jmx.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
