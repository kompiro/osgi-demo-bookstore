bookstoreデモアプリケーション

written by Hiroki Kondo

このアプリケーションでは、一般にMaven2のリポジトリで配布されていない、H2 databaseのJaQuというライブラリを使っています。
(と言っても、H2のソースから簡単にビルドできます。)
個人ではMaven2のリポジトリを運用していないため、JaQuをビルドしたライブラリをデモに同梱しています。
バージョンの不整合を防ぐため、H2 Databaseも併せて試す前にローカルにインストールしてください。

mvn install:install-file -Dfile=h2-1.2.128.jar -DgroupId=com.h2database -DartifactId=h2 -Dversion=1.2.128 -Dpackaging=jar
mvn install:install-file -Dfile=h2jaqu-1.2.128.jar -DgroupId=com.h2database -DartifactId=h2jaqu -Dversion=1.2.128 -Dpackaging=jar
