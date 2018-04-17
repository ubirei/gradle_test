# gradle_test
gradleを試して見る

## init 手順
1. git cloneでソースコードをコロン

    ```
    git clone https://github.com/nexway/sms_api.git
    ```
1. Eclipseプロジェクトを生成

    ```
    gradle eclipse
    ```
1. Eclipseを立ち上げて、projectをインポートする
    <img width="532" alt="Import_と_workspace_-_Eclipse.png (122.5 kB)" src="https://img.esa.io/uploads/production/attachments/3366/2018/04/16/10383/6500176d-ba77-4c76-9b53-2676a13e178b.png">

1. ライブラリをダウンロードする
    <img width="1049" alt="スクリーンショット 2018-04-17 13.59.51.png (457.8 kB)" src="https://img.esa.io/uploads/production/attachments/3366/2018/04/17/10383/8d9fc83b-33a5-472e-9f7f-551ff0df3ccb.png">

1. コンソールで下記コマンドを実行し、Tomcatを起動してデプロイする

    ```
    gradle tomcatRunWar
    ```

1. コンソールで下記コマンドを実行して、起動に成功したことを確認

    ```
    curl -X GET http://localhost:8080/sms_api/resources/sample
    curl -X POST -F "part=part1" http://localhost:8080/sms_api/resources/form/part
    curl -X POST -F "file=@test.txt" http://localhost:8080/sms_api/resources/form/part-file-name
    ```
    注意：`test.txt`のあるフォルダで実行すること
