CC = javac
EXEC = Runnable

all: ; $(CC) $(EXEC).java

run: ; java $(EXEC)

clean: ; rm *.class */*.class

rebuild: clean all;
