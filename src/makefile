JC = javac

# Diretórios...
BIN=../bin

JFLAGS = -g -d $(BASE)$(BIN)

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Ponto3D.java \
	Vertice.java \
	SemiAresta.java \
	Face.java\
	poliedro.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) $(BASE)$(BIN)/*.class
