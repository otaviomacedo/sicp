lein clean
lein deps
java -cp "src:test:classes:lib/*" lazytest.watch src test
