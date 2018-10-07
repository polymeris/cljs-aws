(ns cljs-aws.greengrass
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "Greengrass" "greengrass-2017-06-07.min.json")
