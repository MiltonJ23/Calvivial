export PATH_TO_BUILD=build
export PATH_TO_FX=lib/javaFx
export PATH_TO_SRC=src/org/duke/counterburry

echo "Building Controller Class...."
javac -d build -cp "$PATH_TO_FX/*:$PATH_TO_BUILD" $PATH_TO_SRC/CoreController.java

echo "Building the Main Class...."
javac -d build -cp "$PATH_TO_FX/*:$PATH_TO_BUILD" $PATH_TO_SRC/Main.java

echo "Copying all the resources...."
cp -r res build

echo "Building the Jar File"
jar cvfm Test.jar MANIFEST.MF -C build/ .
