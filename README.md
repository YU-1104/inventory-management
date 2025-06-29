# inventory-management
このリポジトリは、実務に近い環境でのAWSおよびPostgreSQLを用いたシステム開発経験を積むことを目的に、三人チームで作成している在庫管理システムの学習プロジェクトです。
現在、Lambda関数とAmazon RDS（PostgreSQL）との接続が確認できており、S3にアップロードしたJARファイルを使用したLambda単体テストまで実装済みです。

## 使用技術
Java 21  
AWS Lambda  
AWS RDS（PostgreSQL）  
AWS S3  

## 現時点の進捗
Lambda関数からRDSへJDBC経由での接続確認済み  
Lambda単体でのテスト実行成功  
S3にデプロイしたビルド成果物（JAR）をLambdaで利用  
CloudWatch Logs によるログ出力・監視設定  

RDSとの接続確認は以下
[src/main/java/com/inventory/management/lambda/Handler.java](https://github.com/YU-1104/inventory-management/blob/main/src/main/java/com/inventory/management/lambda/Handler.java)

## 今後の予定（学習・実装予定）
在庫の登録・更新・削除・アラート機能の実装　　
フロントも作成予定

## 背景・目的
このプロジェクトは、未経験からAWSやクラウド開発に取り組むことを目的にスタートしました。  
メンバー3名のうち2名がIT業界での勤務経験を持ち、互いに知見を共有しながら、AWSの基本操作や設計方針を確認し合い、開発を進めています。  
クラウドインフラの基礎からチーム開発の協調性まで、幅広く学ぶ機会となっています。  
現在16回まで開催しており、情報は[notion](https://bristle-cuckoo-e16.notion.site/1-16-21e4e07638cc8075b201f34cafbc07dd?source=copy_link)でまとめて共有しています。 





