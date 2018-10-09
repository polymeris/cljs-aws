# cljs-aws

Unofficial, experimental, pre-alpha AWS client for Clojurescript using core.async on Node.

## Usage

```clojure
(ns example
  (:require [cljs.core.async :refer [go <!]]
            [cljs-aws.s3 :as s3]))
            
(go (<! (s3/create-bucket {:bucket                      "examplebucket"
                           :create-bucket-configuration {:location-constraint "eu-west-1"}})))
;=> {:location "http://examplebucket.s3.amazonaws.com/"}
; or
;=> {:error "msg"}
```

### Authentication

Use the underlying [node authentication mechanism](https://docs.aws.amazon.com/sdk-for-javascript/v2/developer-guide/setting-credentials-node.html).

### Examples

c.f `examples/cljs_aws/src/*.cljs`

Set your AWS credentials, e.g.:
```
export AWS_PROFILE=myprofile
export AWS_REGION=us-east-1
```
Then, build and run:
```
cd examples
lein npm install
lein cljsbuild once dynamodb        # or another example
node target/dynamodb.js 
```

## Development

Install the AWS SDK via npm:
```
lein npm install
```

The tests are ran with doo:

```
lein doo once
```
