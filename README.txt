bookstoreデモアプリケーション

written by Hiroki Kondo

このアプリケーションでは、一般にMaven2のリポジトリで配布されていない、H2 databaseのJaQuというライブラリを使っています。
(と言っても、H2のソースから簡単にビルドできます。)
個人ではMaven2のリポジトリを運用していないため、JaQuをビルドしたライブラリをデモに同梱しています。
バージョンの不整合を防ぐため、H2 Databaseも併せて試す前にローカルにインストールしてください。

mvn install:install-file -Dfile=h2-1.2.128.jar -DgroupId=com.h2database -DartifactId=h2 -Dversion=1.2.128 -Dpackaging=jar
mvn install:install-file -Dfile=h2jaqu-1.2.128.jar -DgroupId=com.h2database -DartifactId=h2jaqu -Dversion=1.2.128 -Dpackaging=jar

1. Mock Bundleでの起動
# cd bookstore
# pax-provision
[OSGiランタイムが起動]
> ss (稼働中のBundleの状況が確認できる)
Mockサービスとして動いていることを確認する

2. Mock->implへ変更
# cd books.impl
# mvn install
> install file:///home/kompiro/codes/java/osgi-demo/bookstore/books2/target/books2-2.0.0.jar
> install file:///home/kompiro/codes/java/osgi-demo/bookstore/books.impl/target/books.impl-0.1.0.impl.jar
> install file:///home/kompiro/.m2/repository/com/h2database/h2/1.2.128/h2-1.2.128.jar
> install file:///home/kompiro/.m2/repository/com/h2database/h2jaqu/1.2.128/h2jaqu-1.2.128.jar

> start org.kompiro.bookstore.books.impl
[Bundle IDを確認]

(データが空の事を確認)
(Like検索していることを確認)

3. impl->Mockへ変更
> stop org.kompiro.bookstore.books.impl

(データが元のMockのデータを参照していることを確認)

4. Mockとimplを同時実行(システムの中で同一系のサービスを起動)
 1. webが参照するbooksのバージョンをbooks2に
    e JaQuBookServiceを開き、BookService以外にBookService2を実装していることを確認
    e src/main/webapp/WEB-INF/shop-osgi.xmlを開き、BookService→BookService2
    # cd ../web
    # mvn install
> uninstall org.kompiro.bookstore.web
> install file://...(mvnでインストールしたパス)
> start org.kompiro.bookstore.web
ソースをみて、それぞれ違うサービスで動いていることを確認してみる。
