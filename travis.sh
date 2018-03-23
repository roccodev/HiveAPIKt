#!/usr/bin/bash

if [ -z ${TRAVIS_TAG+x} ] eval $gradle bintrayUpload