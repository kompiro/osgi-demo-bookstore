bookstoreデモアプリケーション

written by Hiroki Kondo

このアプリケーションでは、一般にMaven2のリポジトリで配布されていない、H2 databaseのJaQuというライブラリを使っています。
(と言っても、H2のソースから簡単にビルドできます。)
個人ではMaven2のリポジトリを運用していないため、JaQuをビルドしたライブラリをデモに同梱しています。
バージョンの不整合を防ぐため、H2 Databaseも併せて試す前にローカルにインストールしてください。

mvn install:install-file -Dfile=h2-1.2.128.jar -DgroupId=com.h2database -DartifactId=h2 -Dversion=1.2.128 -Dpackaging=jar
mvn install:install-file -Dfile=h2jaqu-1.2.128.jar -DgroupId=com.h2database -DartifactId=h2jaqu -Dversion=1.2.128 -Dpackaging=jar

== デモ実行のために必要なもの ==
 * Maven 2系
 * Pax Construct 1.4
http://wiki.ops4j.org/display/paxconstruct/Downloadからダウンロードしてください。

== 記号の意味 ==
# : コマンド入力
> : OSGiコンソール上の操作
e : ソース編集


1. Mock Bundleでの起動
# cd bookstore
# mvn install
... (各プロジェクトのビルドをします。)

# pax-provision
[OSGiランタイムが起動]
> ss (稼働中のBundleの状況が確認できます)
id	State       Bundle
...
34	ACTIVE      org.kompiro.bookstore.books.domain_1.0.0
35	ACTIVE      org.kompiro.bookstore.books_0.1.0
36	ACTIVE      org.kompiro.bookstore.web_0.1.0
37	ACTIVE      org.springframework.bundle.spring.webmvc_2.5.4
38	ACTIVE      org.kompiro.bookstore.web.admin_0.1.0
39	ACTIVE      org.kompiro.bookstore.books.mock_0.1.0.mock

という感じで表示されます。
Mockサービスとして動いていることを確認してください。

検索画面
http://localhost:8080/shop/search.htm

登録画面
http://localhost:8080/admin/register.htm

それぞれのページのHTMLソースを開くと、
途中に現在動作中のサービス名が表示されています。

2. Mock->implへ変更
# cd books.impl
# mvn install

installで指定できるJARのパスはURLです。今回はローカルのファイルのため、file://を接頭辞として指定します。Windowsの場合はfile://C:/...、LinuxやMacの場合は、file:///...(ルートからのパス)で指定してください。
> install file:///{bookstoreまでの絶対パス}/books2/target/books2-2.0.0.jar
> install file:///{bookstoreまでの絶対パス}/books.impl/target/books.impl-0.1.0.impl.jar
> install file:///{bookstoreまでの絶対パス}/h2-1.2.128.jar
> install file:///{bookstoreまでの絶対パス}/h2jaqu-1.2.128.jar

> stop org.kompiro.bookstore.books.mock
> uninstall org.kompiro.bookstore.books
> start org.kompiro.bookstore.books_2.0.0のID(左端の番号)
> start org.kompiro.bookstore.books.impl
> refresh
> ss
[Bundle IDを確認]

> update org.kompiro.bookstore.web
> update org.kompiro.bookstore.web.admin
(データが空の事を確認)
http://localhost:8080/shop/search.htmにアクセスし、検索してみましょう。
http://localhost:8080/admin/register.htmにアクセスし、登録してみましょう。
(Like検索していることを確認)

http://localhost:8080/shop/search.htmにアクセスし、Like検索してみましょう。
＊残念ながら、日本語はLike検索できません。JaQuの振る舞いの確認ではないので既存の障害にしてください。

3. impl->Mockへ変更
> stop org.kompiro.bookstore.books.impl
> start org.kompiro.bookstore.books.mock
> update org.kompiro.bookstore.web
> upate org.kompiro.bookstore.web.admin

(データが元のMockのデータを参照していることを確認)

4. Mockとimplを同時実行(システムの中で同一系のサービスを起動)
e JaQuBookServiceを開き、BookService以外にBookService2を実装していることを確認
e src/main/webapp/WEB-INF/shop-osgi.xmlを開き、BookService→BookService2
# cd ../web
# mvn install
> start org.kompiro.bookstore.books.impl
> uninstall org.kompiro.bookstore.web
> install file://...(mvnでインストールしたパス)
> refresh
> start org.kompiro.bookstore.web
HTMLソースをみて、それぞれ違うサービスで動いていることを確認しましょう。

== OSGiコンソールコマンドの意味 ==
ss:現在稼働中のBundle状態を一覧表示
install url:urlで指定したBundleを新たにインストールします。
uninstall id or symbolic_name:指定したBundleをアンインストールします。
start id or symbolic_name:指定したBundleを活性化します。サービスのインストールもこの時に行われます。
stop id or symbolic_name:指定したBundleを非活性化します。サービスのアンインストールもこの時に行われます。
refresh:現在installされているBundleのうち、更新されたものを読み込み直します。
update id or symbolic_name:指定したBundleを更新します。
