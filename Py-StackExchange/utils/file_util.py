#!/usr/bin/env python
# -*- coding: UTF-8 -*-
import sys
reload(sys)
sys.setdefaultencoding('utf-8')

def read_data(filename):
    documents = []
    temp = ''
    f =open(filename,'r')
    for line in f.readlines():
        if '---------------------' in line:
            documents.append(temp)
            temp = ''
            continue
        temp += line.strip()
    print(documents)
    return documents

def read_info(filename):
    documents = []
    
    f =open(filename,'r')
    for line in f.readlines():
        if line.strip() != '' and '---------------------' not in line:
            documents.append(line.strip())
    f.close()
    # print(documents)
    return documents

def write_data(filename, *contents):
    # if not os.path.exists(filename):
    #     os.system(r"touch {}".format(filename))
    string = ''
    if len(contents) > 1:
        for s in contents:
            string = string + s + ','
    else:
        string = contents[0]
    string += '\n'
    # string += '---------------------------------------------\n'
    f = open(filename, 'a+')
    f.write(string)
    f.close()

