CC = javac
EXEC = Exec

all: ; $(CC) $(EXEC).java

run: ; java $(EXEC)

clean: ; rm *.class */*.class */*/*.class

rebuild: clean all;
