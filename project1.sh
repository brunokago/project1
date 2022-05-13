#!/bin/bash
if [ $# -eq 0 ]
  then
    echo "No arguments supplied"
    else
        javac Solution.java
        java Solution.java $1
fi


