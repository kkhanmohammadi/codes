
# coding: utf-8

# In[1]:


API_Key=""# enter your API key


# In[20]:


import requests
params = {'apikey': ''} # enter your API key
files = {'file': ('156_04134211F5E4FC47B6E1225C48D9C62A8348FB6B373F9A6CC52F735A52638E2E.apk', open('D:/Ava/Empirical2018/test/Adwares/ads/156_04134211F5E4FC47B6E1225C48D9C62A8348FB6B373F9A6CC52F735A52638E2E.apk', 'rb'))}
response = requests.post('https://www.virustotal.com/vtapi/v2/file/scan', files=files, params=params)
json_response = response.json()


# In[22]:


json_response


# In[32]:


import json
jdump=json.dumps(json_response)
jdata=json.loads(jdump)
jdata['resource']


# In[7]:


params = {'apikey': '', 'resource': '04134211f5e4fc47b6e1225c48d9c62a8348fb6b373f9a6cc52f735a52638e2e'}
headers = {
  "Accept-Encoding": "gzip, deflate",
  "User-Agent" : "gzip,  My Python requests library example client or username"
  }
response = requests.get('https://www.virustotal.com/vtapi/v2/file/report',
  params=params, headers=headers)
json_response = response.json()
        


# In[34]:


response.json()


# In[2]:


import pandas as pd
data = pd.read_csv("D:/Ava/Empirical2018/journal/repackaging_pairs.txt") 
data.head()


# In[11]:


repackagedNameType = pd.read_csv("D:/Ava/Empirical2018/repackagedMalwareLabel-name-type.csv", header=None) 
repackagedNameType.head()
repackagedNameType.columns = ["no", "repackaged", "Name", "Type","None"]
repackagedNameType.head()


# In[16]:


repackagedNameTypeUnknown=data[~data['SHA256_REPACKAGE'].isin(repackagedNameType['repackaged'])]


# In[17]:


repackagedNameTypeUnknown.head()


# In[18]:


repackagedNameTypeUnknown.to_csv("D:/Ava/Empirical2018/repackagedNameTypeUnknown.csv")


# In[31]:


import os
for file in os.listdir("E:/Ava1/RepackagedNameTypeUnknown"):
    print(os.path.join("E:/Ava1/RepackagedNameTypeUnknown/", file))


# In[4]:


#D:\Ava\Empirical2018\journal\repackagedNameTypeUnknownJson
import time
import requests
import sys
import os
import hashlib
import argparse
import logging
import requests
import json
from requests.exceptions import ConnectionError
i=0
path="E:/Ava1/RepackagedNameTypeUnknown/8"
for file in sorted(os.listdir("E:/Ava1/RepackagedNameTypeUnknown/8")):
    size=os.path.getsize(os.path.join("E:/Ava1/RepackagedNameTypeUnknown/8", file))
   # print(size)
    if(size<80000000):
        print(os.path.join("E:/Ava1/RepackagedNameTypeUnknown/8", file))
        jdump=''

        try:
            with open(os.path.join("E:/Ava1/RepackagedNameTypeUnknown/8", file), 'rb') as of:
                files = {'file': (file, of)}
                params = {'apikey': ''}
                response = requests.post('https://www.virustotal.com/vtapi/v2/file/scan', files=files, params=params)
                print('1:'+str(i))
                json_response = response.json()
                jdump=json.dumps(json_response)
            jdata=json.loads(jdump)
            params = {'apikey': '', 'resource': jdata['resource']}
            headers = {  "Accept-Encoding": "gzip, deflate",  "User-Agent" : "gzip,  My Python requests library example client or username"}
            response = requests.get('https://www.virustotal.com/vtapi/v2/file/report',params=params, headers=headers)
            print('2:'+str(i))
            json_response = response.json()

            with open(os.path.join('D:/Ava/Empirical2018/journal/repackagedNameTypeUnknownJson/repackagedNameTypeUnknownJson.txt'),'a') as wfile:#,file[:-4] + '.txt'), 'w') as wfile:
                wfile.write(json.dumps(json_response)+'\n')
                wfile.flush()
            i=i+1
        except ConnectionError as e:    # This is the correct syntax
            print ('error: ConnectionError')
            print (e)
        except ValueError as e:  # includes simplejson.decoder.JSONDecodeError
            print ('Decoding JSON has failed')
            print (e)
        except Exception:
            print ('Error:all_other_exceptions')
            print (e)
        time.sleep(15)
            #of.close()
        os.rename(os.path.join(path,file),os.path.join(path,'a'+file))
print('done!')
    


# In[12]:


path='E:/Ava1/RepackagedNameTypeUnknown/mytest'
for file in (os.listdir("E:/Ava1/RepackagedNameTypeUnknown/mytest")):
    print (file[:-4] + '.txt')
    of=open(os.path.join("E:/Ava1/RepackagedNameTypeUnknown/mytest", file), 'rb')
    files = {'file': (file, of)}
    of.close()
    os.rename(os.path.join(path,file),os.path.join(path,'a'+file))
    
                  


# In[58]:


i=0
i=i+1
print('i'+str(i))


# In[71]:


for file in sorted(os.listdir("E:/Ava1/RepackagedNameTypeUnknown/2")):
    print(os.path.join("E:/Ava1/RepackagedNameTypeUnknown/2", file))
    size=os.path.getsize(os.path.join("E:/Ava1/RepackagedNameTypeUnknown/2", file))
    print(size)
    if(size>21000000):
        print("***********************************************")
    
    #files = {'file': (file, of=open(os.path.join("E:/Ava1/RepackagedNameTypeUnknown/2", file), 'rb'))}
    #of.close()

