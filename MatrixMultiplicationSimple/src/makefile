CC=gcc
SOURCE_EXT=c
EXEC_EXT=exe

all: $(patsubst %.$(SOURCE_EXT),%.$(EXEC_EXT),$(wildcard *.$(SOURCE_EXT)))

%.$(EXEC_EXT): %.$(SOURCE_EXT)
	$(CC) $< -o $@

$@: $@.$(EXEC_EXT)

.PHONY: clean

clean:
	rm -f *.$(EXEC_EXT)