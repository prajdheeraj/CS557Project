include java.mk

# Be sure to set this before compiling ...
  VERSION = 1.2.17
     DIST = ivy-$(VERSION).jar 
     DOCS = doc/html/api
     #dist = woody/
     dist = 

all: class examples

examples:
	( cd examples; make; )

class:
	( cd src; make; )
	grep -H TODO src/*java

docs:
	( cd src; make docs ; )

tests:
	( cd tests; ant )

#dist: class docs 
dist: class docs 
	(cd src && $(JAR) cvfm ../$(DIST) ../manifest fr/dgac/ivy/*.class fr/dgac/ivy/tools/*.class )

jar: class
	ln -sf src/fr .
	ln -sf ${HOME}/dev/bundle/${dist}gnu .
	ln -sf ${HOME}/dev/bundle/${dist}org .
	$(JAR) cfm ivy-java.jar manifest fr/dgac/ivy/*.class fr/dgac/ivy/tools/*.class src/Makefile src/*.java README COPYING.LIB Changelog BUGS gnu org examples/*.java 
	/bin/rm -f gnu org
	
clean:
	( cd src; make clean ;)
	( cd tests; make clean ; )
	( cd examples; make clean; )
	rm -f -- $(DIST)

install:
	install -m 0755 tools/jprobe $(DESTDIR)/usr/bin/
	install -m 0755 tools/jafter $(DESTDIR)/usr/bin/
	install -m 0755 tools/jdaemon $(DESTDIR)/usr/bin/
	install -m 0644 doc/ivy-java.1 $(DESTDIR)/usr/man/man1/
	gzip -9 $(DESTDIR)/usr/man/man1/ivy-java.1
	install -m 0644 doc/jprobe.1 $(DESTDIR)/usr/man/man1/
	gzip -9 $(DESTDIR)/usr/man/man1/jprobe.1
	install -m 0644 $(DIST) $(DESTDIR)/usr/share/java/ivy.jar
	(cd src; $(MAKE) docs DOCS=$(DESTDIR)/usr/share/doc/libivy-java/html/api)
	#cp -R doc/ivy-java $(DESTDIR)/usr/share/doc/libivy-java/programmersguide
	#install -m 0644 doc/ivy-java.pdf $(DESTDIR)/usr/share/doc/libivy-java/
