(ns cljs-aws.base.requests-test
  (:require [clojure.test :refer [deftest is async]]
            [cljs.core.async :as a]
            [cljs-aws.base.requests :as requests]))

(def test-service-name "test-service")
(def test-operation-name "test-operation")
(def test-params {:test-param-1 :foo})

(defn successful-mock-perform-request!
  [_ operation-name js-params callback]
  (callback nil (clj->js [:success operation-name js-params])))

(defn error-mock-perform-request!
  [_ operation-name _ callback]
  (callback (str "error in " operation-name) nil))

(def expected-aws-keys
  #{"Config"
    "ElasticTranscoder"
    "DeviceFarm"
    "ELBv2"
    "KMS"
    "ElastiCache"
    "RDS"
    "Request"
    "CognitoIdentityCredentials"
    "CodePipeline"
    "AutoScaling"
    "CloudWatchEvents"
    "config"
    "StorageGateway"
    "CloudTrail"
    "WAF"
    "Firehose"
    "MTurk"
    "SSM"
    "WorkDocs"
    "util"
    "Signers"
    "LexRuntime"
    "STS"
    "ApplicationAutoScaling"
    "ParamValidator"
    "CloudHSM"
    "Iot"
    "ElasticBeanstalk"
    "CredentialProviderChain"
    "APIGateway"
    "XML"
    "Response"
    "EC2"
    "VERSION"
    "MobileAnalytics"
    "Route53"
    "Redshift"
    "ECS"
    "Rekognition"
    "HttpRequest"
    "Model"
    "Credentials"
    "OpsWorks"
    "ECR"
    "ELB"
    "Protocol"
    "CognitoIdentityServiceProvider"
    "Polly"
    "CloudWatch"
    "JSON"
    "CloudFront"
    "CUR"
    "DirectConnect"
    "SNS"
    "events"
    "GameLift"
    "Lambda"
    "ConfigService"
    "CloudWatchLogs"
    "CognitoSync"
    "EventListeners"
    "WebIdentityCredentials"
    "Inspector"
    "DynamoDBStreams"
    "MarketplaceCommerceAnalytics"
    "Kinesis"
    "Endpoint"
    "SequentialExecutor"
    "IotData"
    "MachineLearning"
    "Route53Domains"
    "DynamoDB"
    "EFS"
    "CodeDeploy"
    "SQS"
    "S3"
    "CloudFormation"
    "Service"
    "CognitoIdentity"
    "ACM"
    "CodeCommit"
    "SES"
    "HttpResponse"
    "ServiceCatalog"
    "EMR"
    "HttpClient"})

(deftest require--aws-valid
  (is (some? requests/aws))
  (is (empty? (clojure.set/difference                       ; Note not all of the services are available in the default
                expected-aws-keys                           ; browser build
                (set (goog.object/getKeys requests/aws))))))

(deftest require--memoized-service--ok
  (is (some? (requests/memoized-service "S3"))))

(deftest valid-successful--request--ok
  (async done
    (a/go (with-redefs
            [requests/perform-request! successful-mock-perform-request!]
            (is (= ["success" "test-operation" {:test-param-1 "foo"}]
                   (a/<! (requests/request test-service-name test-operation-name test-params))))
            (done)))))

(deftest valid-error--request--error
  (async done
    (a/go (with-redefs
            [requests/perform-request! error-mock-perform-request!]
            (is (= {:error "error in test-operation"}
                   (a/<! (requests/request test-service-name test-operation-name test-params))))
            (done)))))
