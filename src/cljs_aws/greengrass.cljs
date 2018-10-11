(ns cljs-aws.greengrass
  (:require [cljs-aws.base.requests])
  (:require-macros [cljs-aws.base.service :refer [defservice]]))

(defservice "Greengrass" "greengrass-2017-06-07.min.json")
