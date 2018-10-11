# cljs-aws

Unofficial, experimental, pre-alpha AWS client for Clojurescript using core.async on Node or in the browser.

[![Clojars](https://img.shields.io/clojars/v/cljs-aws.svg?style=flat)](https://clojars.org/cljs-aws)
[![CircleCI](https://circleci.com/gh/polymeris/cljs-aws.svg?style=svg)](https://circleci.com/gh/polymeris/cljs-aws)

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

For node, use the underlying [node authentication mechanism](https://docs.aws.amazon.com/sdk-for-javascript/v2/developer-guide/setting-credentials-node.html).

For the browser, use a Cognito identity pool.

### Examples

The [`node-examples`](node-examples/src/cljs_aws) and [`browser-examples`](browser-examples/src/cljs_aws) directories contains a few examples on how to use different AWS services.

#### Node
 
To run Node examples, first set your AWS credentials, e.g.:
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

#### Browser

To run browser examples, follow [the first step in this tutorial](https://docs.aws.amazon.com/sdk-for-javascript/v2/developer-guide/getting-started-browser.html)
to create a Cognito Identity Pool, then give the IAM role associated with unauthenticated users permissions to access the
service you are testing.

Then edit the example to use your Cognito Identity Pool ID:

```
(requests/set-cognito-identity! "EDIT_ME") ; FIXME This function will probably change!
```

Then run figwheel:
```
cd browser-examples
lein npm install
lein figwheel lambda
```

## Development

Install the AWS SDK via npm:
```
lein npm install
```

The tests are ran with doo:
```
lein doo node test-node auto            # or "once"
lein doo phantom test-browser auto
```
