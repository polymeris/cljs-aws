# cljs-aws

Unofficial AWS client for Clojurescript using core.async on Node or in the browser.

Tested and working, but still to be considered in **alpha** stage, any interfaces might change.

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

For node, use the underlying
[node authentication mechanism](https://docs.aws.amazon.com/sdk-for-javascript/v2/developer-guide/setting-credentials-node.html),
in practice most likely setting your credentials using environment variables like `AWS_PROFILE` or `AWS_ACCESS_KEY_ID`
and `AWS_SECRET_ACCESS_KEY`. 

For the browser, use a Cognito identity pool, and load the credentials as follows:
```clojure
(config/load-credentials! :cognito-identity-credentials {:identity-pool-id "<id>"})
```

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
cd node-examples
lein cljsbuild once dynamodb        # or another example
node target/dynamodb.js 
```

#### Browser

To run browser examples, follow [the first step in this tutorial](https://docs.aws.amazon.com/sdk-for-javascript/v2/developer-guide/getting-started-browser.html)
to create a Cognito Identity Pool, then give the IAM role associated with unauthenticated users permissions to access the
service you are testing.

Edit the example code to use your Cognito Identity Pool ID, and run figwheel:
```
cd browser-examples
lein figwheel lambda
```

### A note on naming, parameters and return values

The names of the functions in each namespace are generated automatically from the PascalCase'd operation names,
so for instance DynamoDB's [`PutItem`](https://docs.aws.amazon.com/AWSJavaScriptSDK/latest/AWS/DynamoDB.html#putItem-property)
operation becomes `dynamodb/put-item`.
Parameters and return values are also converted between camel-case and PascalCase for you, so for instance, in 
`(dynamodb/describe-table {:table-name "mytable"})`, the parameter will become `{"TableName": "mytable"}`.

However, there are cases were that's not desirable. In particular, when using DynamoDB, the schema might contain
all lower-case or all upper-case named columns, and some types are also indicated by all upper-case strings, like
`BS`, `NS`, `SS`.

cljs-aws doesn't try to be clever about those special cases (let's leave that for a higher level library), but instead
allows you to pass string keys, which (unlike keywords) will not be re-cased or transformed in any way:
```clojure
(dyanmodb/put-item {:table-name "mytable"
                    :item       {"id"         {"S" "foo"}       ; "id" *not* re-cased to "Id"
                                 :numbers-set {"NS" #{}}}})     ; :numbers-set *is* PascalCased'd, but "NS" is not  
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
