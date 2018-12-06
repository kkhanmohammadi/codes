
# coding: utf-8

# In[22]:


import pandas as pd
apkNames = pd.read_csv("D:/Ava/Empirical2018/apkNameOriginalRepackaged-New.csv", header=None, encoding = "ISO-8859-1") 
apkNames.head()
#import csv
#gpsTrack = open("D:/Ava/Empirical2018/apkNameOriginalRepackaged-NewText.txt", "r")
#csvReader = csv.reader(gpsTrack)
#for row in csvReader:
 #  print (row)
apkNames.iloc[:,3]


# In[17]:


from langdetect import detect
detect("War doesn't show who's right, just who's left.")


# In[59]:


originalName=apkNames.iloc[:,3].copy()
originalName
#langOriginal=map(detect,originalName)
#langOriginal
langDetect = lambda x: detect(x)
d2 = []
for item in originalName:
    d2.append(detect(item)) 
#d1=list(map(langDetect, originalName));


# In[64]:


print(len(d2))


# In[42]:


apkNames.iloc[2,3]


# In[45]:


detect('Gang Wars one for me one for you')


# In[65]:


d2


# In[70]:


repackagedName=apkNames.iloc[:,1].copy()

langDetect = lambda x: detect(x)
d1 = []
for item in repackagedName:
    d1.append(detect(item)) 


# In[71]:


print(len(d1))


# In[72]:


import numpy as np
np.savetxt("D:/Ava/Empirical2018/repackagedNameLanguage.csv", d2, delimiter=",", fmt='%s')


# In[73]:


np.savetxt("D:/Ava/Empirical2018/originalNameLanguage.csv", d1, delimiter=",", fmt='%s')

