#!/usr/bin/env python
# -*- coding: UTF-8 -*-

import sys
sys.path.append('.')
sys.path.append('..')
import re
import stackexchange

pat = re.compile('(?<=\>).*?(?=\<)')
test = '<p>I am developing an android app and I am planning to publish it (paid app). I have heard that it is very easy to pirate Android apps (much easier than iphone). I was wondering from your experience or what you know, how can increase the security of my app? I know that I can never get it 100% secured but I want to make it harder for people to pirate it or distribute it illegally'+\
'Any ideas, experiences, comments you can share?</p>'+\
'\n'+\
''
print test
body = ''.join(pat.findall(test))
print pat.findall(test)
print body

user_api_key = 'fAEE*hhUg6RZwKnjsGLYng(('
site = stackexchange.Site(stackexchange.StackOverflow, app_key=user_api_key)
site.be_inclusive()
id = 30675899
question = site.question(id)
print question.body
code_pat_str = r'(<pre.*?><code>.*?</code></pre>)'
body = re.sub('\n', '', question.body)
code_pat = re.compile(code_pat_str)
# body = re.sub('\n', '', html_text)
code = re.findall(code_pat_str, body)
print('code: ')
print(code)