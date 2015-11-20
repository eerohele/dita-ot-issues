(ns factorial
  (:require [clojure.core.match :refer [match]]))

(defn fact-iter [n acc]
  (match n
         1 acc
         2 acc
         :else (recur (dec n) (* acc (dec n)))))

(defn factorial [n]
  (fact-iter n n))

(factorial 10)
