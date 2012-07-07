all:				UpperServer.class UpperClient.class

UpperServer.class:		UpperServerThread.class UpperServer.java
				@javac UpperServer.java

UpperServerThread.class:	UpperServerThread.java
				@javac UpperServerThread.java

UpperClient.class:		UpperClient.java
				@javac UpperClient.java

clean:
				@rm -rf *.class *~

info:
				@echo "Origem:"
				@echo "   Roland Teodorowitsch"
				@echo "   29 maio 2009"
