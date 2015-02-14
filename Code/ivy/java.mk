#
# (c) CENA
# Author Yannick Jestin <jestin@cena.fr>
#
# a simple way to use the same java/javac/classpath declaration across the
# subdirectories ( ivy source, tests, examples )
# Changelog:
#   1.2.8 first
#

  #GNUPATH =/usr/share/java/gnu-getopt.jar:/usr/share/java/regexp.jar
 # on my MAC
#  GNUPATH =${HOME}/dev/bundle
GNUPATH = /usr/share/java/gnu-getopt.jar:/usr/share/java/regexp.jar# debian woody
#GNUPATH = ${HOME}/java/Jars/gnu.getopt.jar:${HOME}/java/Jars/regexp.jar # Others
#RTPATH = /usr/local/jdk1.5.0/jre/lib/rt.jar # for jikes on my box
#RTPATH = /usr/local/jdk118_v3/lib/classes.zip:/home/jestin/java/Jars/swingall.jar # for 1.1.8 on my box

CLASSPATH = -classpath $(GNUPATH):./src:.

#JAVA = kaffe
JAVA = java
#JAVA = gij
#JAVAC = gcj -C --encoding=8859_1 -Wall -g
#JAVAC = javac -target 1.5
JAVAC = javac
#JAVAC =  /usr/local/j2sdk1.4.2/bin/javac
#JAVACOPTS = 
#JAVACOPTS = -target 1.2
JAR = jar



#######################################
# jikes setup on my box
#######################################
#   RTPATH = /usr/lib/j2re1.3/lib/rt.jar
#   RTPATH = /usr/local/j2sdk1.4.1/jre/lib/rt.jar
#JIKESPATH = ${RTPATH}:/usr/share/java/gnu.getopt.jar:/usr/share/java/repository
#JAVACOPTS = -d . -deprecation
#    JAVAC = jikes -classpath $(JIKESPATH):$(ADD)
#######################################
# blackdown jdk118 setup
#######################################
#    JAVAC = /usr/local/jdk118_v3/bin/javac
#CLASSPATH = -classpath .:/usr/local/jdk118_v3/lib/classes.zip:/home/jestin/java/Jars/swingall.jar:$(ADD)
#JAVACOPTS = -d .

######################################
# local Blackdown linux 1.2.2
######################################
#CLASSPATH = -classpath .:$(ADD)
#JAVACOPTS = -deprecation -d .
#    JAVAC = /usr/local/jdk1.2.2/bin/javac

######################################
# local Blackdown linux 1.3.1
######################################
#CLASSPATH = -classpath .:$(ADD)
#JAVACOPTS = -deprecation
#JAVAOPTS =
#JAVA = /usr/local/j2sdk1.3.1/bin/java 
#JAVAC = /usr/local/j2sdk1.3.1/bin/javac


