(ns jetty-jmx.core
  (:require [ring.adapter.jetty9 :refer [run-jetty]])
  (:import (java.lang.management ManagementFactory)
           (org.eclipse.jetty.jmx MBeanContainer))
  (:gen-class))

(defn dummy [request]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "JMXable"})

(defn -main
  [& args]
  (let [mb-container (MBeanContainer. (ManagementFactory/getPlatformMBeanServer))]
    (doto (run-jetty dummy {:port 8000
                            :join? false})
      (.addEventListener mb-container)
      (.addBean mb-container))))
