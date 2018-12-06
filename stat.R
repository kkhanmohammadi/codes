#Permision number original vs repackaged
repackagedComponents<-read.csv(file="D:/Ava/Empirical2018/repackagedCountComponents_noName.csv", header=FALSE, sep=",")
originalComponents<-read.csv(file="D:/Ava/Empirical2018/originalCountComponents_noName.csv", header=FALSE, sep=",")
plot(originalComponents[ ,6],repackagedComponents[ ,6], ,xlab="Number of permissions in original applications", ylab="Number of permissions in repackaged applications", cex=0.8)
> repackagedComponents[,6]

Permissions all########################
permissionsAdded<-read.csv(file="D:/Ava/Empirical2018/pairs-permissionsAdded-InEachLine-Nopackage.csv", header=FALSE, sep=",")
padded<-table(permissionsAdded)
par(las=2, mar=c(26,4,2,2), cex=0.75)

a<-head(padded[order(-padded)],n=30)
barplot(padded[order(-padded)], ylim=range(0,100))

> dim(permissionsAdded)
[1] 388   1
par(las=2, mar=c(26,4,2,2), cex=0.75)
barplot(padded[order(-padded)], ylim=range(0,100))
title(xlab="Permissions added in repackaged apps", mgp=c(24,1,0))
title(ylab="Number of applications", mgp=c(2,1,0))

permissionsDel<-read.csv(file="D:/Ava/Empirical2018/adware_pairs-permissionsDeleted-InEachLine_New.csv", header=FALSE, sep=",")
> dim(permissionsDel)
[1] 184   1
pDel<-table(permissionsDel)
par(las=2, mar=c(26,4,2,2), cex=0.75)
barplot(pDel[order(-pDel)], ylim=range(0,40))
title(xlab="Permissions deleted from original apps", mgp=c(20,1,0))
title(ylab="Number of applications", mgp=c(2,1,0))


##############Permissions for adware
permissionsAdded<-read.csv(file="D:/Ava/Empirical2018/adware_pairs-permissionsAdded-InEachLine_New.csv", header=FALSE, sep=",")
padded<-table(permissionsAdded)
> dim(permissionsAdded)
[1] 388   1
par(las=2, mar=c(26,4,2,2), cex=0.75)
barplot(padded[order(-padded)], ylim=range(0,80))
title(xlab="Permissions added in repackaged apps", mgp=c(19,1,0))
title(ylab="Number of applications", mgp=c(2,1,0))

permissionsDel<-read.csv(file="D:/Ava/Empirical2018/adware_pairs-permissionsDeleted-InEachLine_New.csv", header=FALSE, sep=",")
> dim(permissionsDel)
[1] 184   1
pDel<-table(permissionsDel)
par(las=2, mar=c(26,4,2,2), cex=0.75)
barplot(pDel[order(-pDel)], ylim=range(0,40))
title(xlab="Permissions deleted from original apps", mgp=c(20,1,0))
title(ylab="Number of applications", mgp=c(2,1,0))



################################################
###APK names
apkNames<-read.csv(file="D:/Ava/Empirical2018/apkNameOriginalRepackaged-New.csv", header=FALSE, sep=",")
nameDist<-adist(apkNames[,1],apkNames[,2])
>nrow(apkNames)
[1] 15293
> library(stringdist)
> cousineSim <- 1-stringdist(as.character(apkNames[,2]),as.character(apkNames[,4]),method='cosine')
> summary(cousineSim)
   Min. 1st Qu.  Median    Mean 3rd Qu.    Max.    NA's 
 0.0000  0.3810  0.6530  0.6253  0.9257  1.0000       3 
> boxplot(cousineSim)
title(ylab="Cosine similarity", mgp=c(2,1,0))

> co<-cousineSim[cousineSim<0.5]
> head(co)
[1] 0.09534626 0.00000000 0.22792115 0.35032452 0.26375219 0.00000000
> length(co)
[1] 5414

#####################################Name changing obfuscation
> chisq.test(x=c(96,4),p=c(0.57,0.43))

        Chi-squared test for given probabilities

data:  c(96, 4)
X-squared = 62.056, df = 1, p-value = 3.338e-15

> chisq.test(x=c(96.1,3.9),p=c(0.57,0.43))

        Chi-squared test for given probabilities

data:  c(96.1, 3.9)
X-squared = 62.375, df = 1, p-value = 2.839e-15

> chisq.test(x=c(96.1,3.9),p=c(0.27,0.73))

        Chi-squared test for given probabilities

data:  c(96.1, 3.9)
X-squared = 242.25, df = 1, p-value < 2.2e-16

> chisq.test(x=c(96.1,3.9),p=c(0.27,0.73))$p-value
Error: object 'value' not found
> chisq.test(x=c(96.1,3.9),p=c(0.27,0.73))$p.value
[1] 1.268887e-54

#################################3
#Kaggle dataset vs original agreate star-rating

apps <- read.csv(file="C:/Ava/Docs/Empirical/apps.csv", header=TRUE, sep=",")
> dim(apps)
[1] 296704     11
freeApps<-apps[apps$price=='0.0',]
> dim(freeApps)
[1] 245427     11
rateAll<-table(freeApps[ ,7])
boxplot(as.numeric(as.character(freeApps[ , 7])), data=freeApps)

> originalKaggle <- read.csv(file="C:/Ava/Docs/Empirical/originalAppsDetailsKaggleClean.csv", header=FALSE, sep=",")

> rate<-table(originalKaggle[ ,7])
> boxplot(originalKaggle[ , 7], data=originalKaggle, outline=FALSE)
> wilcox.test(originalKaggle[ ,7], mu = 3,alternative = "greater")

        Wilcoxon signed rank test with continuity correction

boxplot(originalKaggle[,7],as.numeric(as.character(freeApps[ , 7])), names = c("Apps get repackaged", "All apps"), ylab="Aggregate star-rating")
> summary(as.numeric(as.character(freeApps[ , 7])))
   Min. 1st Qu.  Median    Mean 3rd Qu.    Max. 
  0.000   3.500   4.000   3.587   4.417   5.000 
wilcox.test(originalKaggle[,7],as.numeric(as.character(freeApps[ , 7])))

originalKaggle$newDate<-str_replace_all(originalKaggle[,2], "Februar", "February")
originalKaggle$newDate<-str_replace_all(originalKaggle$newDate, "Mai", "May")
originalKaggle$newDate<-str_replace_all(originalKaggle$newDate, "Juni", "June")
originalKaggle$newDate<-str_replace_all(originalKaggle$newDate, "Juli", "July")
originalKaggle$newDate<-str_replace_all(originalKaggle$newDate, "Dezember", "December")
originalKaggle$newDate<-str_replace_all(originalKaggle$newDate, "Marz", "March")
originalKaggle$newDate<-str_replace_all(originalKaggle$newDate, "Januar", "January")
originalKaggle$newDate<-str_replace_all(originalKaggle$newDate, "Oktober", "October")

originalKaggle$year<-as.Date(as.character(originalKaggle$newDate),"%d. %B %Y")
originalKaggle$Y<-substring(originalKaggle$year,0,4)
originalKaggle2014<-originalKaggle[which(originalKaggle$Y==2014),]
originalKaggle2013<-originalKaggle[which(originalKaggle$Y==2013),]
originalKaggle2012<-originalKaggle[which(originalKaggle$Y==2012),]

freeApps$newDate<-str_replace_all(freeApps[,2], "Februar", "February")
freeApps$newDate<-str_replace_all(freeApps$newDate, "Mai", "May")
freeApps$newDate<-str_replace_all(freeApps$newDate, "Juni", "June")
freeApps$newDate<-str_replace_all(freeApps$newDate, "Juli", "July")
freeApps$newDate<-str_replace_all(freeApps$newDate, "Dezember", "December")
freeApps$newDate<-str_replace_all(freeApps$newDate, "Marz", "March")
freeApps$newDate<-str_replace_all(freeApps$newDate, "Januar", "January")
freeApps$newDate<-str_replace_all(freeApps$newDate, "Oktober", "October")

freeApps$year<-as.Date(as.character(freeApps$newDate),"%d. %B %Y")
freeApps$Y<-substring(freeApps$year,0,4)
freeApps2014<-freeApps[which(freeApps$Y==2014),]
freeApps2013<-freeApps[which(freeApps$Y==2013),]
freeApps2012<-freeApps[which(freeApps$Y==2012),]

par(las=2, mar=c(10,4,2,2))
boxplot(originalKaggle2012[,7],as.numeric(as.character(freeApps2012[ , 7])),originalKaggle2013[,7],as.numeric(as.character(freeApps2013[ , 7])),originalKaggle2014[,7],as.numeric(as.character(freeApps2014[ , 7])), names = c("Original 2012", "All apps 2012","Original 2013", "All apps 2013","Original 2014", "All apps 2014" ))
title(ylab="Aggregate star-rating", mgp=c(2,1,0))

wilcox.test(originalKaggle2012[,7],as.numeric(as.character(freeApps2012[ , 7])))
> wilcox.test(originalKaggle2012[,7],as.numeric(as.character(freeApps2012[ , 7])))

        Wilcoxon rank sum test with continuity correction

data:  originalKaggle2012[, 7] and as.numeric(as.character(freeApps2012[, 7]))
W = 480070, p-value = 0.03054
alternative hypothesis: true location shift is not equal to 0

> wilcox.test(originalKaggle2013[,7],as.numeric(as.character(freeApps2013[ , 7])))

        Wilcoxon rank sum test with continuity correction

data:  originalKaggle2013[, 7] and as.numeric(as.character(freeApps2013[, 7]))
W = 4258800, p-value = 0.3694
alternative hypothesis: true location shift is not equal to 0

> wilcox.test(originalKaggle2014[,7],as.numeric(as.character(freeApps2014[ , 7])))

        Wilcoxon rank sum test with continuity correction

data:  originalKaggle2014[, 7] and as.numeric(as.character(freeApps2014[, 7]))
W = 32455000, p-value = 0.1595
alternative hypothesis: true location shift is not equal to 0

> wilcox.test(originalKaggle[,7],as.numeric(as.character(freeApps[ , 7])))

        Wilcoxon rank sum test with continuity correction

data:  originalKaggle[, 7] and as.numeric(as.character(freeApps[, 7]))
W = 88559000, p-value = 0.01523
alternative hypothesis: true location shift is not equal to 0

#################################################
# Number of downloads
repackagedKaggle <- read.csv(file="C:/Ava/Docs/Empirical/repackagedAppsDetailsKaggle.csv", header=FALSE, sep=",")
downloadNumber1<-table(repackagedKaggle[ ,3])
downloadNumber1[is.na(downloadNumber1)]<-0
downloadNumber1<-downloadNumber1[2:16]
downloadNumber<-round(prop.table(downloadNumber1)*100,2)
par(las=2, mar=c(12,4,2,2))
barplot(downloadNumber, ylim=range(0,25))
title(xlab="Number of Downloads", mgp=c(5,1,0))
title(ylab="Percentage of Applications", mgp=c(2,1,0))




originalKaggle <- read.csv(file="C:/Ava/Docs/Empirical/originalAppsDetailsKaggleClean.csv", header=FALSE, sep=",")
downloadNumber1<-table(originalKaggle[ ,3])
downloadNumber<-round(prop.table(downloadNumber1)*100,2)

alldownloadNumber<-table(as.numeric(as.character(freeApps[ ,3])))
barplot(alldownloadNumber)
allDownloadNumber<-round(prop.table(alldownloadNumber)*100,2)


#par(las=2, mar=c(12,4,2,2))
#barplot(downloadNumber, ylim=range(0,140))
#colnames(allDownloadNumber) <- c("0", "1","5","10","50","100","500","1000","5000","10000","50000","100000","500000","1000000","5000000","10000000","50000000","100000000","500000000","1000000000")
names(allDownloadNumber)[12]<-"100000"
names(allDownloadNumber)[13]<-"500000"
names(allDownloadNumber)[14]<-"1000000"
names(allDownloadNumber)[15]<-"5000000"
names(allDownloadNumber)[16]<-"10000000"
names(allDownloadNumber)[17]<-"50000000"
names(allDownloadNumber)[18]<-"100000000"
names(allDownloadNumber)[19]<-"500000000"

res<-merge(as.data.frame(allDownloadNumber),as.data.frame(downloadNumber),by.x=1,by.y=1,all=TRUE)
colnames(res)<-c("DownloadNumber","All apps","Original apps")
res[is.na(res)]<-0
a<-res[1:18,]
#a<-head(res[order(-res$Repackaged),],n=20)
#a<-res[order(-res$DownloadNumber),]

cols <- c('red','blue')
ylim <- c(0,max(a[c('All apps','Original apps')]));

par(las=2, mar=c(15,3,1,1), cex=0.8, lwd = 2)

barplot(
    t(a[c('All apps','Original apps')]),
    beside=T,
    ylim=range(0,25),
    border=c('red','blue'),
    col=c('red','blue'),
    names.arg=a$DownloadNumber,
    cex.names=1.0,
    legend.text=c('All apps','Original apps'),
    args.legend=list(text.col=cols,col=cols,border=cols,fill = c("red", "blue"),bty='n')
);
title(xlab="Download Number", mgp=c(5,1,0))
title(ylab="Percentage of Applications", mgp=c(2,1,0))

as.numeric(as.character(freeApps[ ,3]))
originalKaggle[ ,3]
wilcox.test(as.numeric(as.character(freeApps[ ,3])), originalKaggle[ ,3])
> wilcox.test(as.numeric(as.character(freeApps[ ,3])), originalKaggle[ ,3])

        Wilcoxon rank sum test with continuity correction

data:  as.numeric(as.character(freeApps[, 3])) and originalKaggle[, 3]
W = 44471000, p-value < 2.2e-16
alternative hypothesis: true location shift is not equal to 0
wilcox.test(as.numeric(as.character(freeApps2012[ ,3])), originalKaggle2012[ ,3])

> wilcox.test(as.numeric(as.character(freeApps2012[ ,3])), originalKaggle2012[ ,3])

        Wilcoxon rank sum test with continuity correction

data:  as.numeric(as.character(freeApps2012[, 3])) and originalKaggle2012[, 3]
W = 229370, p-value = 1.124e-06
alternative hypothesis: true location shift is not equal to 0

> w$p.value
[1] 1.123686e-06
wilcox.test(as.numeric(as.character(freeApps2013[ ,3])), originalKaggle2013[ ,3])
> wilcox.test(as.numeric(as.character(freeApps2013[ ,3])), originalKaggle2013[ ,3])

        Wilcoxon rank sum test with continuity correction

data:  as.numeric(as.character(freeApps2013[, 3])) and originalKaggle2013[, 3]
W = 2179300, p-value < 2.2e-16
alternative hypothesis: true location shift is not equal to 0

> wilcox.test(as.numeric(as.character(freeApps2013[ ,3])), originalKaggle2013[ ,3])$p.value
[1] 5.622845e-23

wilcox.test(as.numeric(as.character(freeApps2014[ ,3])), originalKaggle2014[ ,3])

> wilcox.test(as.numeric(as.character(freeApps2014[ ,3])), originalKaggle2014[ ,3])

        Wilcoxon rank sum test with continuity correction

data:  as.numeric(as.character(freeApps2014[, 3])) and originalKaggle2014[, 3]
W = 16123000, p-value < 2.2e-16
alternative hypothesis: true location shift is not equal to 0

> wilcox.test(as.numeric(as.character(freeApps2014[ ,3])), originalKaggle2014[ ,3])$p.value
[1] 3.11156e-69

#########

downloadNumber1<-table(originalKaggle2012[ ,3])
downloadNumber<-round(prop.table(downloadNumber1)*100,2)

alldownloadNumber<-table(as.numeric(as.character(freeApps2012[ ,3])))
barplot(alldownloadNumber)
allDownloadNumber<-round(prop.table(alldownloadNumber)*100,2)

names(allDownloadNumber)[12]<-"100000"
names(allDownloadNumber)[13]<-"500000"
names(allDownloadNumber)[14]<-"1000000"
names(allDownloadNumber)[15]<-"5000000"
names(allDownloadNumber)[16]<-"10000000"
names(allDownloadNumber)[17]<-"50000000"
names(allDownloadNumber)[18]<-"100000000"
names(allDownloadNumber)[19]<-"500000000"

res<-merge(as.data.frame(allDownloadNumber),as.data.frame(downloadNumber),by.x=1,by.y=1,all=TRUE)
colnames(res)<-c("DownloadNumber","All apps","Original apps")
res[is.na(res)]<-0
a<-res[2:16,]
#a<-head(res[order(-res$Repackaged),],n=20)
#a<-res[order(-res$DownloadNumber),]

cols <- c('red','blue')
ylim <- c(0,max(a[c('All apps','Original apps')]));

par(las=2, mar=c(15,4,1,1), cex=0.8, lwd = 2)

barplot(
    t(a[c('All apps','Original apps')]),
    beside=T,
    ylim=range(0,25),
    border=c('red','blue'),
    col=c('red','blue'),
    names.arg=a$DownloadNumber,
    cex.names=1.0,
    legend.text=c('All apps','Original apps'),
    args.legend=list(text.col=cols,col=cols,border=cols,fill = c("red", "blue"),bty='n')
);
title(xlab="Number of Downloads for applications in 2012", mgp=c(5,1,0))
title(ylab="Percentage of Applications", mgp=c(2,1,0))








########################################3
#original vs repackaged ad libraries#######################################

repackagedAd <- read.csv(file="C:/Ava/Docs/Empirical/repackagedAdlibrariesChanged.csv", header=FALSE, sep=",")
tad<-table(repackagedAd[ ,2])
ad<-round(prop.table(tad)*100,2)
#ad<-table(repackagedAd[ ,2])
par(las=2, mar=c(12,4,2,2))
barplot(ad[order(-ad)], ylim=range(0,100), ylab="Number of applications", xlab="")
title(xlab="Advertisement libraries", mgp=c(11,1,0))

originalAd <-read.csv(file="D:/Ava/Empirical2018/originalAdlibraries-InEachLine.csv", header=TRUE, sep=",")
toad<-table(originalAd[ ,1])
oad<-round(prop.table(toad)*100,2)
par(las=2, mar=c(12,4,2,2))
barplot(oad[order(-oad)],ylim=range(0,100), ylab="Number of applications", xlab="")
title(xlab="Advertisement libraries", mgp=c(11,1,0))

res<-merge(as.data.frame(ad),as.data.frame(oad),by.x=1,by.y=1,all=TRUE)
colnames(res)<-c("Libraries","Repackaged","Original")
res[is.na(res)]<-0
a<-head(res[order(-res$Repackaged),],n=20)
#a<-res[order(-res$Repackaged),]

cols <- c('red','blue')
ylim <- c(0,max(a[c('Repackaged','Original')]));

par(las=2, mar=c(15,3,1,1), cex=0.8, lwd = 2)

barplot(
    t(a[c('Repackaged','Original')]),
    beside=T,
    ylim=range(0,40),
    border=c('red','blue'),
    col=c('red','blue'),
    names.arg=a$Libraries,
    cex.names=1.0,
    legend.text=c('Repackaged','Original'),
    args.legend=list(text.col=cols,col=cols,border=cols,fill = c("red", "blue"),bty='n')
);
title(xlab="Ad Libraries", mgp=c(12,1,0))
title(ylab="percentage of Applications", mgp=c(2,1,0))

##############################################################3





MyData <- read.csv(file="C:/Ava/android/Dataset/theZoo/repackagedAppsDetailsF.csv", header=FALSE, sep=",")
boxplot(MyData[ ,8],data=MyData, main="Virus Detected", xlab="Apps", ylab="Number of Antivirus")

#repackaged <- read.csv(file="C:/Ava/android/Dataset/theZoo/repackagedAppsDetails10.csv", header=FALSE, sep=",")
#original <- read.csv(file="C:/Ava/android/Dataset/theZoo/originalAppsDetails10.csv", header=FALSE, sep=",")
#v<-cbind(repackaged[ ,8],original[ ,8])
colnames(v)<-c("repackaged","original")
#boxplot(v, main = "boxplot", ylab="Number of Antiviruses") # for coloring, col=1:2)


# horiz=TRUE, ## for horizotal chart
vt<-table(MyData[ ,8]) 
barplot(vt, xlab="Virus Detected by # of Antiviruses", ylab="Number of applications", ylim=range(0,8000))

repackagedAd <- read.csv(file="C:/Ava/Docs/Empirical/repackagedAdlibrariesChanged.csv", header=FALSE, sep=",")
ad<-table(repackagedAd[ ,2])
par(las=2, mar=c(12,4,2,2))
barplot(ad[order(-ad)])
barplot(ad)
#> summary(ad)
#Number of cases in table: 1969 
#Number of factors: 1 

repackagedAdNone <- read.csv(file="C:/Ava/Docs/Empirical/repackagedAdlibrariesChangedAddedNone.csv", header=FALSE, sep=",")
adN<-table(repackagedAdNone[ ,2])
par(las=2, mar=c(12,4,2,2))
barplot(adN)
barplot(adN[order(-adN)])
#> summary(adN)
#Number of cases in table: 399 
#Number of factors: 1 

repackagedAd <- read.csv(file="C:/Ava/Docs/Empirical/adLibrariesChangedAll.csv", header=FALSE, sep=",")
ad<-table(repackagedAd[ ,2])
par(las=2, mar=c(12,4,2,2))
barplot(ad[order(-ad)])
> barplot(ad[order(-ad)], ylim=range(0,700), ylab="Number of applications", xlab="")
> title(xlab="Advertisement libraries", mgp=c(11,1,0))
#Number of cases in table: 2368 
#Number of factors: 1 

repackagedAdData <- read.csv(file="C:/Ava/Docs/Empirical/adLibrariesChangedDetails.csv", header=FALSE, sep=",")
VD <- table(repackagedAdData[ ,8])
barplot(VD[order(-VD)])
summary(repackagedAdData[ ,8])
  #Min. 1st Qu.  Median    Mean 3rd Qu.    Max. 
  #1.000   2.000   3.000   4.395   5.000  21.000 

originalKaggle <- read.csv(file="C:/Ava/Docs/Empirical/originalAppsDetailsKaggleClean.csv", header=FALSE, sep=",")
downloadNumber<-table(originalKaggle[ ,3])
par(las=2, mar=c(12,4,2,2))
barplot(downloadNumber, ylim=range(0,140))

#summary(originalKaggle[ , 7])
#   Min. 1st Qu.  Median    Mean 3rd Qu.    Max.    NA's 
#  0.000   3.753   4.032   3.948   4.324   5.000       1 
boxplot(originalKaggle[ , 7], data=originalKaggle)
> t.test(originalKaggle[ ,7],mu=3)

        One Sample t-test

data:  originalKaggle[, 7]
t = 33.251, df = 684, p-value < 2.2e-16
alternative hypothesis: true mean is not equal to 3
95 percent confidence interval:
 3.892168 4.004143
sample estimates:
mean of x 
 3.948156 

> qt(0.975, 684)
[1] 1.963438


original <- read.csv(file="C:/Ava/Docs/Empirical/originalAppsDetailsF.csv", header=FALSE, sep=",")
market<-table(original[ ,11])
par(las=2, mar=c(16,4,2,2))
barplot(market[order(-market)], ylim=range(0,10000))

originalKaggle <- read.csv(file="C:/Ava/Docs/Empirical/originalAppsDetailsKaggleClean.csv", header=FALSE, sep=",")
downloadNumber<-table(originalKaggle[ ,3])
par(las=2, mar=c(12,4,2,2))
barplot(downloadNumber, ylim=range(0,140))
> barplot(downloadNumber, ylim=range(0,140), xlab="", ylab="Number of original applications")
> title(xlab="Number of Downloads", mgp=c(5,1,0))
boxplot(originalKaggle[ , 3], data=originalKaggle, outline=FALSE)


> originalKaggle <- read.csv(file="C:/Ava/Docs/Empirical/originalAppsDetailsKaggleClean.csv", header=FALSE, sep=",")

> rate<-table(originalKaggle[ ,7])
> boxplot(originalKaggle[ , 7], data=originalKaggle, outline=FALSE)
> wilcox.test(originalKaggle[ ,7], mu = 3,alternative = "greater")

        Wilcoxon signed rank test with continuity correction

data:  originalKaggle[, 7]
V = 216970, p-value < 2.2e-16
alternative hypothesis: true location is greater than 3
> wilcox.test(originalKaggle[ ,7], mu = 3.469,alternative = "greater")

        Wilcoxon signed rank test with continuity correction

data:  originalKaggle[, 7]
V = 212780, p-value < 2.2e-16
alternative hypothesis: true location is greater than 3.469


> originalDetail<-read.csv(file="C:/Ava/Docs/Empirical/originalAppsDetailsF.csv", header=FALSE, sep=",")
> repackagedDetail<-read.csv(file="C:/Ava/Docs/Empirical/repackagedAppsDetailsF.csv", header=FALSE, sep=",")
> plot(originalDetail[,5],repackagedDetail[,5], ylab="Repackaged application' size", xlab="Original application' size")
>abline(0,1, col="blue")


> cor(originalDetail[,5],repackagedDetail[,5], method="spearman")
[1] 0.9040915
> cor(originalDetail[,5],repackagedDetail[,5], method="kendall")
[1] 0.7622576
> cor(originalDetail[,5],repackagedDetail[,5], method="pearson")
[1] 0.753308
> ks.test(originalDetail[,5],repackagedDetail[,5])

        Two-sample Kolmogorov-Smirnov test

data:  originalDetail[, 5] and repackagedDetail[, 5]
D = 0.12663, p-value < 2.2e-16
alternative hypothesis: two-sided

Warning message:
In ks.test(originalDetail[, 5], repackagedDetail[, 5]) :
  p-value will be approximate in the presence of ties


originalComponents<-read.csv(file="C:/Ava/Docs/Empirical/originalCountComponentsCompleteFinal.csv", header=FALSE, sep=",")
repackagedComponents<-read.csv(file="C:/Ava/Docs/Empirical/repackagedCountComponentsComplete.csv", header=FALSE, sep=",")
> dim(repackagedComponents)
[1] 15278     7
> dim(originalComponents)
[1] 15278     7
> cor(originalComponents[ ,2],repackagedComponents[ ,2], method="spearman")
[1] 0.9873701
> plot(originalComponents[ ,2],repackagedComponents[ ,2])

apkNames<-read.csv(file="C:/Ava/Docs/Empirical/apkNameOriginalRepackaged.csv", header=FALSE, sep=",")
nameDist<-adist(apkNames[,1],apkNames[,2])
>nrow(apkNames)
[1] 9179
library(RecordLinkage)
LevSim<-levenshteinSim(as.character(apkNames[,1]),as.character(apkNames[,2]))
boxplot(LevSim)
> summary(LevSim)
   Min. 1st Qu.  Median    Mean 3rd Qu.    Max. 
 0.0000  0.1111  0.2308  0.3670  0.5000  1.0000 

> write.csv(LevSim, file="C:/Ava/Docs/Empirical/APKNamesLevenshteinSimilarity.csv")
> > JSim<-jarowinkler(as.character(apkNames[,1]),as.character(apkNames[,2]))
> summary(JSim)
   Min. 1st Qu.  Median    Mean 3rd Qu.    Max. 
 0.0000  0.4433  0.5570  0.5964  0.7632  1.0000 
> library(stringdist)
> jwsim<-1-stringdist(apkNames[,1],apkNames[,2],method='jw')
> boxplot(jwsim)
> boxplot(jwsim)
> summary(jwsim)
   Min. 1st Qu.  Median    Mean 3rd Qu.    Max. 
 0.0000  0.4333  0.5429  0.5842  0.7221  1.0000 
> 
> summary(cousineSim)
   Min. 1st Qu.  Median    Mean 3rd Qu.    Max.    NA's 
 0.0000  0.3771  0.6429  0.6202  0.9381  1.0000       2 
>> cousineSim <- 1-stringdist(as.character(apkNames[,1]),as.character(apkNames[,2]),method='jaccard')
> summary(cousineSim)
   Min. 1st Qu.  Median    Mean 3rd Qu.    Max. 
 0.0000  0.2143  0.3750  0.4455  0.5789  1.0000 
> boxplot(cousineSim)

#Components numbers
> originalComponents<-read.csv(file="C:/Ava/Docs/Empirical/originalCountComponentsCompleteFinal.csv", header=FALSE, sep=",")
> repackagedComponents<-read.csv(file="C:/Ava/Docs/Empirical/repackagedCountComponentsComplete.csv", header=FALSE, sep=",")
> dim(repackagedComponents)
[1] 15278     7
> dim(originalComponents)
[1] 15278     7

par( mfrow = c( 2, 2 ) )
plot(originalComponents[ ,2],repackagedComponents[ ,2],xlab="Original application", ylab="Repackaged application", main="# of Activities")
plot(originalComponents[ ,3],repackagedComponents[ ,3], ,xlab="Original application", ylab="Repackaged application", main="# of Services")
plot(originalComponents[ ,4],repackagedComponents[ ,4], ,xlab="Original application", ylab="Repackaged application", main="# of Receivers")
plot(originalComponents[ ,5],repackagedComponents[ ,5], ,xlab="Original application", ylab="Repackaged application", main="# of Content Providers")
plot(originalComponents[ ,6],repackagedComponents[ ,6], ,xlab="Original application", ylab="Repackaged application", main="# of Permissions")
> 


 act<-as.integer(originalComponents[ ,2])-as.integer(repackagedComponents[ ,2])
> table(act)
act
  -13    -9    -8    -7    -6    -4    -3    -2    -1     0     1     2     3 
    6     4     1     1    27    15    44    77   444 14366   218    42    14 
    4     5     6     7    11    12    16    21    24 
    2     3     3     5     2     1     1     1     1 

>  ser<-as.integer(originalComponents[ ,3])-as.integer(repackagedComponents[ ,3])
> table(ser)
ser
  -25   -21   -12    -7    -6    -5    -4    -3    -2    -1     0     1     2 
    1     1     1     6    10     1    10     3    23   159 15016    11     4 
    3     6     7    13 
    3     1    22     6 
>  rec<-as.integer(originalComponents[ ,4])-as.integer(repackagedComponents[ ,4])
> table(ser)
ser
  -25   -21   -12    -7    -6    -5    -4    -3    -2    -1     0     1     2 
    1     1     1     6    10     1    10     3    23   159 15016    11     4 
    3     6     7    13 
    3     1    22     6 
>  pro<-as.integer(originalComponents[ ,5])-as.integer(repackagedComponents[ ,5])
>  per<-as.integer(originalComponents[ ,6])-as.integer(repackagedComponents[ ,6])
> table(rec)
rec
  -15   -11    -6    -4    -3    -2    -1     0     1     2     5 
    1     8     1     7     2    30   163 15043    14     5     4 
> table(pro)
pro
   -3    -2    -1     0     1     2 
    1    15    10 15241     7     4 
> table(per)
per
  -80   -48   -28   -23   -22   -21   -18   -17   -16   -15   -13   -12   -11 
    8     1     1     2     5     1     2     2     2     3     1    12     4 
   -9    -8    -7    -6    -5    -4    -3    -2    -1     0     1     2     3 
   19    47     8    92    27    28    56    72   270 14262   205    64    37 
    4     5     6     7     8     9    10    12    14    16    24 
    4    16     7     1     3     7     1     1     4     1     2 




activities<-read.csv(file="C:/Ava/Docs/Empirical/pairs-activityNmaes.csv", header=FALSE, sep=",")
> dim(activities)
[1] 14396     2
cousineAct <- 1-stringdist(as.character(activities[,1]),as.character(activities[,2]),method='cosine')
> summary(cousineAct)
   Min. 1st Qu.  Median    Mean 3rd Qu.    Max. 
 0.4024  1.0000  1.0000  0.9954  1.0000  1.0000 
> boxplot(cousineAct)


services<-read.csv(file="C:/Ava/Docs/Empirical/pairs-servicesNmaes.csv", header=FALSE, sep=",")
 cousineSer <- 1-stringdist(as.character(services[,1]),as.character(services[,2]),method='cosine')
> dim(services)
[1] 7466    2
> summary(cousineSer)
   Min. 1st Qu.  Median    Mean 3rd Qu.    Max. 
 0.0000  1.0000  1.0000  0.9996  1.0000  1.0000 
> table(cousineSer)
cousineSer
                0 0.498527242750791 0.750291775861759 0.879007968080566 
                1                 1                 1                 1 
0.884083304218292  0.89622483188448 0.906492521467547 0.917003210539081 
                1                 1                 1                 2 
0.921564938024565 0.927754807560276 0.936441710371274 0.938674076853298 
                1                 1                 1                 1 
0.939999755671173 0.944262717366282 0.950450912354328 0.955695412091724 
                1                 2                 1                 1 
0.957073300952945 0.966576835012449 0.971335416494301   0.9758435875773 
                2                 1                 1                 1 
0.983665047975964 0.984383848056283  0.98691248220962 0.987891269803929 
                2                 1                 1                 1 
0.988167391346323 0.990538025572359 0.991110934737254 0.992767469520773 
                1                 1                 1                 1 
0.992856293171034 0.992912503061172 0.994335691653035 0.996244135619416 
                1                 1                 1                 1 
  0.9964094903213 0.998683828999915                 1 
                1                 1              7428 

receivers<-read.csv(file="C:/Ava/Docs/Empirical/pairs-receiversNmaes.csv", header=FALSE, sep=",")
> dim(receivers)
[1] 9914    2
 cosineRec <- 1-stringdist(as.character(receivers[,1]),as.character(receivers[,2]),method='cosine')
>table(cosineRec)
cosineRec
0.638666373658505 0.774688353762044 0.808113656761697 0.847588006244244 
                2                 1                 1                 6 
0.883178650662202 0.896327928756292 0.901921914778759  0.90844046833408 
                1                 1                 1                 1 
0.917097006424031 0.927105069301107 0.942115263028452 0.943034505373991 
                1                 1                 1                 1 
0.945905302926917 0.954920122986319 0.959043019636509 0.959390722290647 
                1                 1                 2                 1 
0.963701322036677 0.970651625516228 0.971164634548102 0.984939218001748 
                1                 1                 1                 3 
0.996140915558165 0.996896813601764 0.998264064960778  0.99868871444472 
                1                 1                 1                 3 
0.998719907727363 0.998995965670559 0.999071802121747 0.999123599351349 
                1                 1                 1                 1 
0.999153794059899 0.999211772631464 0.999247221159301 0.999262170197213 
                1                 1                 1                 1 
0.999285153433018 0.999290141223643 0.999301891997391 0.999318410835846 
                1                 1                 1                 1 
0.999332990178272 0.999364193050678 0.999369690837715 0.999403793742679 
                1                 1                 1                 1 
0.999425692769681  0.99943997577097 0.999499538900666 0.999527837459968 
                1                 1                 1                 1 
0.999560324227324 0.999577678204498                 1 
                1                 1              9857 
contents<-read.csv(file="C:/Ava/Docs/Empirical/pairs-contentProvidersNmaes.csv", header=FALSE, sep=",")
 cosineCon <- 1-stringdist(as.character(contents[,1]),as.character(contents[,2]),method='cosine')
> dim(contents)
[1] 493   2
>  cosineCon <- 1-stringdist(as.character(contents[,1]),as.character(contents[,2]),method='cosine')
> table(cosineCon)
cosineCon
0.649575285819936 0.883427278529449 0.937339990408419 0.951716153059164 
                1                 1                 1                 1 
0.956507275686449 0.972058137753353 0.972968168246282 0.974494888529326 
                2                 1                 1                 1 
0.975178037342222 0.996183225067239 0.999248924602848                 1 
                1                 1                 1               481 
> > par( mfrow = c( 2, 2 ) )
> boxplot(cousineAct, main="Activities")
> boxplot(cousineSer, main="Services")
> boxplot(cosineRec, main="Receivers")
> boxplot(cousineAct, main="Activities")



permissions<-read.csv(file="C:/Ava/Docs/Empirical/pairs-permissionsNmaes.csv", header=FALSE, sep=",")
> dim(permissions)
[1] 14109     2
CosinePer<-1-stringdist(as.character(permissions[,1]),as.character(permissions[,2]),method='cosine')
> table(CosinePer)
CosinePer
0.988596787152667 0.991629744642506 0.993452720731233 0.993997984638303 
                1                 1                 1                 1 
0.995029042549987  0.99571124195902 0.995848853706304  0.99592314844986 
                1                 1                 1                 1 
0.996758276926469 0.996817338353627 0.996867667473209 0.996947144157468 
                2                 1                 4                 1 
0.996992464321896 0.997168066882942  0.99731955807168 0.997370314243626 
                1                 1                 1                 1 
0.997692139187622 0.997811229962913 0.998123251460508  0.99814814655901 
                7                 1                 1                 1 
0.998178831135574 0.998330728909209 0.998367735494734 0.998420731643844 
                1                 9                 1                 1 
0.998521966289787 0.998613983834421 0.998640074547998 0.998761907462158 
                1                 1                 1                 1 
0.998960826450295 0.999027567022346 0.999028923456319 0.999030897670879 
                1                 1                 1                 2 
0.999049311325001 0.999089644531062  0.99913336600629 0.999151296117316 
                1                 1                 1                 1 
0.999179628368376 0.999193511375501 0.999241317165112 0.999328621540451 
                1                 1                 1                 1 
0.999357604930061 0.999379914493718 0.999403532130038 0.999423529703285 
                1                 1                 1                 1 
0.999440169417305 0.999489836584262 0.999490252224488 0.999557915207067 
                1                 1                 1                 1 
 0.99956972188565 0.999595334634727 0.999610766066989 0.999635299787447 
                1                 1                 1                 1 
0.999643344918951 0.999686077531113  0.99970814828302 0.999782309982448 
                1                 3                 1                 1 
0.999791189125421 0.999791439077682 0.999830284530292 0.999831486977237 
                1                 1                 1                 1 
0.999872554492897 0.999897106245494 0.999908934929348  0.99993039523895 
                3                 1                 2                 1 
0.999942595648588 0.999952714818195                 1 
                1                 1             14019 



permissionsAdded<-read.csv(file="C:/Ava/Docs/Empirical/pairs-permissionsAdded-InEachLine.csv", header=FALSE, sep=",")
padded<-table(permissionsAdded)
> par(las=2, mar=c(26,4,2,2), cex=0.7)
> barplot(padded[order(-padded)], ylim=range(0,100))

permissionsDel<-read.csv(file="C:/Ava/Docs/Empirical/pairs-permissionsDeleted.csv", header=FALSE, sep=",")
> dim(permissionsDel)
[1] 296   1
>pDel<-table(permissionsDel)
>barplot(pDel[order(-pDel)], ylim=range(0,100))

permissionsSimAdd<-read.csv(file="C:/Ava/Docs/Empirical/pairs-permissionsChangedInSimilarNumber-InEachLine.csv", header=FALSE, sep=",")
> dim(permissionsSimAdd)
[1] 60  2
pSimAdd<-table(permissionsSimAdd)
barplot(pSimAdd[order(-pSimAdd)])

permissionsSimDel<-read.csv(file="C:/Ava/Docs/Empirical/pairs-permissionsdeletedInSimilarNumber.csv", header=FALSE, sep=",")
pairs-permissionsdeletedInSimilarNumber
> dim(permissionsSimDel)
[1] 70  1
> pSimDel<-table(permissionsSimDel)
> par(las=2, mar=c(26,4,2,2), cex=0.7)
> barplot(pSimDel[order(-pSimDel)])
> title(xlab="Permissions", mgp=c(25,1,0))
> title(ylab="Number of applications", mgp=c(2,1,0))
> 
> par(las=2, mar=c(27,4,2,2), cex=0.7)
> barplot(pSimDel[order(-pSimDel)])





repackagedMalwareType<-read.csv(file="D:/Ava/Empirical2018/repackagedMalwareLabel-name-type.csv", header=FALSE, sep=",")
trepackagedMalwareType<-table(repackagedMalwareType[,4])
par(las=2, mar=c(26,6,2,2), cex=0.7)
barplot(trepackagedMalwareType[order(-trepackagedMalwareType)], ylim=range(0,8000))
title(xlab="Malware Type", mgp=c(8,1,0))
title(ylab="Number of applications", mgp=c(3,1,0))

pie(trepackagedMalwareType)
title(ba"Malware Type", line = -4)


head(sort(trepackagedMalwareType, decreasing=TRUE),n=2)
>head(sort(trepackagedMalwareType, decreasing=TRUE),n=2)

adware trojan 
  7460    606 
> dim(trepackagedMalwareType)
[1] 31
> sum(tail(sort(trepackagedMalwareType, decreasing=TRUE),n=29))
[1] 665
> sum(head(sort(trepackagedMalwareType, decreasing=TRUE),n=2))
[1] 8066
slices <- c(7570, 606, 555)
lbls <- c("adware", "trojan", "others")
pie(slices, labels = lbls)
title("Malware Type", line = -1)
> trepackagedMalwareType

        addisplay            adload           adsware            adware 
               34                 5                82              7460 
   adware++adware          backdoor             click   clicker++trojan 
               28                 3                54                87 
          dropper   dropper++trojan        exp++virus           exploit 
                1                 1                 1                 7 
        fakeangry           malware   malware++packer       pws++trojan 
                1                 7                 1                 4 
  risktool++virus          riskware           rootkit           smssend 
               12               132                 1                 1 
              spr               spy       spy++trojan           spyware 
               18                 2                 1                92 
             tool               trj              troj            trojan 
                5                19                58               606 
trojan++trojansms          trojware              worm 
                2                 1                 5 


repackagedMalwareType<-read.csv(file="D:/Ava/Empirical2018/repackagedMalwareLabel-name-type-ChangedCol.csv", header=FALSE, sep=",")
repackagedDetails<-read.csv(file="D:/Ava/Empirical2018/androguardRepackaged.csv", header=FALSE, sep=",")

xy <- merge(repackagedMalwareType, repackagedDetails, by.x = 1, by.y = 1, all.x = TRUE, all.y = FALSE)
write.csv(xy, file="D:/Ava/Empirical2018/repackagedMalwareTypeDetails.csv")

adwareActitities<-read.csv(file="D:/Ava/Empirical2018/added-activityNames-adware.csv", header=FALSE, sep=",")
names(adwareActitities)=c("a","b","c")
>ad<-adwareActitities[adwareActitities$b!="",]
>dim(ad)
[1] 49  3
> dim(adwareActitities)
[1] 98  3

trojanActivities<-read.csv(file="D:/Ava/Empirical2018/added-activityNames-trojan.csv", header=FALSE, sep=",")
names(trojanActivities)=c("a","b","c")
ad<-trojanActivities[trojanActivities$b!="",]
dim(ad)
[1] 182   3
> dim(trojanActivities)
[1] 341   3

adwareServices<-read.csv(file="D:/Ava/Empirical2018/added-servicesNames-adware.csv", header=FALSE, sep=",")
names(adwareServices)=c("a","b","c")
ad<-adwareServices[adwareServices$b!="",]
dim(ad)
[1] 16  3


>trojanServices<-read.csv(file="D:/Ava/Empirical2018/added-servicesNames-trojan.csv", header=FALSE, sep=",")
names(trojanServices)=c("a","b","c")
ad<-trojanServices[trojanServices$b!="",]
dim(ad)
8


malwareTypes<-read.csv(file="D:/Ava/Empirical2018/repackagedMalwareLabel-name-type.csv", header=FALSE, sep=",")
adLibrary<-read.csv(file="D:/Ava/Empirical2018/adLibrariesChangedAll.csv", header=FALSE, sep=",")
>dim(malwareTypes )
[1] 8731    5
> xy <- merge(malwareTypes, adLibrary, by.x = 2, by.y = 1)
> dim(xy)
[1] 2132    6
> dim(adLibrary)
[1] 2368    2
> colnames(repackagedMalwareType)<-c("No","SHA","Name","Type")

> library(plyr)
> count(repackagedMalwareType, c("Name", "Type"))
                  Name              Type freq
1             admobads           adsware   12
2             admobads            adware   28
3               admogo            adware    5
4               adpush            adware    3
5                  ads            adware    4
6                adswo            adware    7
7           adwhirlads           adsware    4
8           adwhirlads            adware   14
9                 adwo            adware   51
10                adwo           spyware    3
11                adwo              troj    1
12                aebf            trojan    1
13                aecw            trojan   15
14              airpus           adsware    1
15              airpus            adware    2
16             airpush            adware 1382
17             allaple              worm    1
18               appax            trojan    2
19           apperhand            adware    1
20         appinventor            adware    1
21         appinventor               spr    1
22         appinventor              troj    1
23            applovin            adware   14
24         applovinads            adware    1
25          appsgeyser            adware   17
26             artemis            adload    5
27             artemis            adware  112
28             artemis              troj    5
29             artemis            trojan   18
30             baiduad            adware    1
31              bankun               spr    1
32          basebridge            trojan    3
33             bbridge              troj    1
34            benjamin              worm    1
35                boqx            adware    1
36                boqx           exploit    1
37                boqx              troj    3
38                boqx            trojan    3
39          burstlyads           adsware    1
40          burstlyads            adware    1
41               cauly            adware   86
42           charboost            adware    2
43        charboostads           adsware    9
44        charboostads            adware   85
45        charboostads            trojan    1
46              cinmus           rootkit    1
47                cnzz         addisplay    1
48            commplat         addisplay    2
49            commplat            adware    5
50               cosha            trojan    4
51                 cve        exp++virus    1
52                 cve           exploit    1
53                 cve            trojan    3
54              cwzgie            trojan    2
55              cwzgis            trojan    1
56              cwzglw            trojan    6
57              cwzgou trojan++trojansms    2
58              cxqisl            trojan    1
59              cxqisx            trojan    3
60              cxsxzo               spy    2
61              cynevs            trojan    2
62              cyoanv            trojan    2
63              dcsfjy            trojan    2
64             ddlight            trojan    5
65                delf            trojan    1
66                deng            adware   67
67                deng          riskware   64
68                deng               spr    4
69                deng              troj    4
70                deng            trojan   18
71         desktoppush            adware    1
72               domob           adsware    4
73               domob            adware   22
74              douwan            adware    3
75              dowgin            adware  269
76              dowgin             click   54
77              dowgin   clicker++trojan   87
78              dowgin          riskware   27
79              dowgin           spyware   61
80              dowgin            trojan  297
81            downadup              worm    2
82         droidkungfu            adware   66
83         droidkungfu          backdoor    1
84         droidkungfu               spr    1
85         droidkungfu              troj    1
86         droidkungfu            trojan    4
87            dupentry           exploit    2
88            eldorado               spr    1
89            eldorado              troj   10
90              fakeav            trojan    2
91            fakengry            trojan    3
92             fcbhzii              troj    2
93             fcbhzij              troj    2
94             fcbhzik              troj    2
95               fjcon            trojan    1
96             fokonge            trojan    1
97              ganlet            trojan    1
98            gappusin           malware    1
99             geimini              troj    1
100              genbl           adsware    2
101              genbl            adware    9
102              genbl              troj   13
103              genbl            trojan   12
104         generickdz            trojan    3
105        ginermaster            trojan    1
106        gingerbreak            trojan    1
107       gingermaster            adware    3
108       gingermaster            trojan   18
109          ginmaster            trojan   64
110        goldentouch            adware    1
111            graftor            adware    8
112      greystripeads           adsware    1
113              gumen          riskware    2
114              gumen            trojan    2
115             gvance            adware    1
116            hupigon          backdoor    1
117              iacgm            trojan    1
118             igexin           smssend    1
119             igexin               spr    1
120             inmobi            adware   11
121             inmobi            trojan    1
122          inmobiads           adsware   25
123          inmobiads            adware  131
124          inmobiads            trojan    1
125               inor           dropper    1
126            jcrypto           malware    1
127          jpgiframe            trojan    1
128            jumptap            adware    1
129              kuguo            adware   42
130              kuguo          riskware    1
131              kuguo              troj    3
132              kuguo            trojan    4
133           leadbolt            adware   97
134              loopb           exploit    1
135             lotoor            adware    1
136             lotoor              troj    1
137             luomao            adware    1
138             luomao          riskware    1
139             luomao              troj    1
140               lzla           malware    1
141        madhouseads           adsware    1
142        madhouseads            adware    3
143             malapp            trojan   11
144              mcare            trojan    2
145 millennialmediaads           adsware   13
146 millennialmediaads            adware   97
147         mmarketpay              troj    1
148           mobclick            adware    5
149         mobclixads           adsware    2
150         mobclixads            adware    4
151          mobilespy              tool    5
152             mobwin            adware  237
153          mobwinads            adware    5
154             moghav            trojan    1
155           morepaks            trojan    1
156               mseg            trojan    3
157              mulad            adware    1
158          nandrobox          riskware    2
159          nandrobox               trj    1
160               nawi            trojan    1
161           nickispy       spy++trojan    1
162             nsanti   malware++packer    1
163              oddjs           malware    3
164              oddjs            trojan    1
165        onlinegames       pws++trojan    4
166             ooqqxx           malware    1
167             opfake            adware    1
168             opfake              troj    2
169             opfake            trojan    1
170           pcclient          backdoor    1
171             picsys              worm    1
172             pircob   risktool++virus   12
173             pircob               spr    5
174             pjapps              troj    1
175           plankton         addisplay    4
176           plankton            adware   11
177           plankton           spyware   28
178           plankton            trojan    4
179   possiblyunwanted            adware    1
180   possiblyunwanted           exploit    1
181         premiumsms          riskware    2
182           rabbhome            trojan    1
183             ramnit   dropper++trojan    1
184             ramnit            trojan    2
185           ranapama            trojan    1
186               ratc           exploit    1
187             revmob         addisplay   26
188             revmob            adware 3710
189             revmob            trojan    1
190          revmobads           adsware    5
191          revmobads            adware   82
192             rooter            trojan    1
193              saiva            trojan   23
194            sendpay            trojan    1
195             shixot            adware    1
196          smalihook               spr    2
197           smsagent          riskware    1
198           smsagent            trojan    1
199            smshoax            adware    2
200             smspay          riskware   20
201             smspay            trojan    1
202             smsspy            trojan   12
203             spybot            adware    2
204          spybubble            trojan    2
205             spyset            trojan    4
206           startapp            adware   50
207           startapp            trojan    3
208            stopsms               spr    1
209            stopsms               trj    5
210           strictor            adware    2
211              symmi              troj    1
212            systush            trojan    1
213             tapjoy            adware    2
214          tapjoyads           adsware    2
215          tapjoyads            adware   27
216               teap            trojan    1
217              umeng         addisplay    1
218              umeng            adware   73
219              umeng    adware++adware   28
220              umeng         fakeangry    1
221              umeng          riskware    6
222              umeng              troj    2
223              utchi            adware    3
224               uten               spr    1
225               uten            trojan    1
226           vdloader            trojan    1
227             viking            trojan    1
228              virut            trojan    2
229              viser            adware   17
230               waps            adware  364
231              wapsx            adware    8
232              winge            trojan    2
233              wiyun            adware    7
234              wiyun          riskware    6
235              wiyun            trojan    1
236             wooboo            adware   13
237              youku            adware    3
238              youmi            adware  172
239              youmi            trojan    1
240               zbot               trj   13
241         zeroaccess          trojware    1
242              zitmo            trojan    6





###############################
 
adwareP<-read.csv(file="D:/Ava/Empirical2018/adware_pairs-permissionsAdded-InEachLine_New_changed.csv", header=FALSE, sep=",")
#adware_pairs-permissionsAdded-InEachLine_New.csv", header=FALSE, sep=",")
tadwareP<-table(adwareP)
par(las=2, mar=c(26,6,2,2), cex=0.7)
barplot(head(tadwareP[order(-tadwareP)],n=20),ylim=range(0,70))#, ylim=range(0,8000))
title(xlab="Adware permissions", mgp=c(16,1,0))
title(ylab="Number of applications", mgp=c(3,1,0))

trojanP<-read.csv(file="D:/Ava/Empirical2018/trojan_pairs-permissionsAdded-InEachLine_New_changed.csv", header=FALSE, sep=",")
ttrojanP<-table(trojanP)
par(las=2, mar=c(26,6,2,2), cex=0.7)
barplot(head(ttrojanP[order(-ttrojanP)],n=20), ylim=range(0,30))#, ylim=range(0,8000))
title(xlab="Trojan permissions", mgp=c(16,1,0))
title(ylab="Number of applications", mgp=c(3,1,0))

pAdwareP<-round(prop.table(tadwareP)*100,2)
pTrojanP<-round(prop.table(ttrojanP)*100,2)

res<-merge(as.data.frame(pAdwareP),as.data.frame(pTrojanP),by.x=1,by.y=1,all=TRUE)
colnames(res)<-c("Permissions","adware","trojan")
res[is.na(res)]<-0
res$dif<-res$adware-res$trojan
#a<-head(res[order(-res$adware),],n=20)
a<-head(res[order(-res$dif),],n=20)

cols <- c('red','blue')
ylim <- c(0,max(a[c('adware','trojan')]));

par(las=2, mar=c(24,4,2,1),cex=0.8, lwd = 2)

barplot(
    t(a[c('adware','trojan')]),
    beside=T,
    ylim=range(0,20),
    border=c('red','blue'),
    col=c('red','blue'),
    names.arg=a$Permissions,
    cex.names=0.8,
    legend.text=c('Adware','Trojan'),
    args.legend=list(text.col=cols,col=cols,border=cols,fill = c("red", "blue"),bty='n')
);
title(xlab="Permissions", mgp=c(16,1,0), cex.lab=0.8)
title(ylab="Percentage of applications", mgp=c(2,1,0), cex.lab=0.8)

box();
xlab='API calls',

adware<-read.csv(file="D:/Ava/Empirical2018/repackaging_pairs_adware.csv", header=FALSE, sep=",")
trojan<-read.csv(file="D:/Ava/Empirical2018/repackaging_pairs_trojan.csv", header=FALSE, sep=",")

adad <- merge(adware, adLibrary, by.x = 2, by.y = 1)
tad<- merge(trojan, adLibrary, by.x = 2, by.y = 1)
> dim(adad)
[1] 2083    3
> dim(tad)
[1] 49  3
> dim(trojan)
[1] 1161    2

> dim(adware)
[1] 7570    2

> dim(adLibrary)
[1] 2368    2

reflection<-read.csv(file="D:/Ava/Empirical2018/reflectionComplete_trojan.csv", header=FALSE, sep=",")
names(reflection)=c("a1","b1","c1","d1","a2","b2","c2","d2")
sum(reflection$c1=="None"&reflection$c2!="None")#reflection
>41
sum(reflection$d1=="None"&reflection$d2!="None")#dex-loader
>2519
> sum(reflection$c1!="None"&reflection$c2!="None")
[1] 15158
> sum(reflection$d1!="None"&reflection$d2!="None")
[1] 8054
> sum(reflection$c1=="None"&reflection$c2=="None")
[1] 93
> sum(reflection$d1=="None"&reflection$d2=="None")
[1] 4676
Adware################
> dim(reflection)
[1] 7567    8
> sum(reflection$c1=="None"&reflection$c2!="None")#reflection
[1] 29
> sum(reflection$d1=="None"&reflection$d2!="None")#dex-loader
[1] 2391
> sum(reflection$c1!="None"&reflection$c2!="None")
[1] 7527
>  sum(reflection$d1!="None"&reflection$d2!="None")
[1] 2793
> sum(reflection$c1=="None"&reflection$c2=="None")
[1] 11
> sum(reflection$d1=="None"&reflection$d2=="None")
[1] 2372
> 
Trojan##########
> reflection<-read.csv(file="D:/Ava/Empirical2018/reflectionComplete_trojan.csv", header=FALSE, sep=",")
> names(reflection)=c("a1","b1","c1","d1","a2","b2","c2","d2")
> dim(reflection)
[1] 1160    8
> sum(reflection$c1=="None"&reflection$c2!="None")#reflection
[1] 4
> sum(reflection$d1=="None"&reflection$d2!="None")#dex-loader
[1] 28
> > sum(reflection$c1!="None"&reflection$c2!="None")
Error: unexpected '>' in ">"
>  sum(reflection$c1!="None"&reflection$c2!="None")
[1] 1122
> sum(reflection$d1!="None"&reflection$d2!="None")
[1] 763
>  sum(reflection$c1=="None"&reflection$c2=="None")
[1] 34
> sum(reflection$d1=="None"&reflection$d2=="None")
[1] 366
> 






#####################package name
repackaged<-read.csv(file="D:/Ava/Empirical2018/repackagedAppsDetailsF.csv", header=FALSE, sep=",")
original<-read.csv(file="D:/Ava/Empirical2018/originalAppsDetailsF.csv", header=FALSE, sep=",")

> dim(original)
[1] 15297    11
> dim(repackaged)
[1] 15297    11
 repackaged[1:10,6]
 [1] com.tekciz.thevoice              com.game.Blackjack.Classic.free1
 [3] com.geniteam.gangwars.lite       org.alps.mobile                 
 [5] net.appholic.poconghunter        com.kabita.beeshooter           
 [7] com.andrimo.duck_shooter         com.mcsentul.shootmyduck        
 [9] com.duck.finoapps                com.tekzom.noisyduck  

> library(stringdist)
> cosinePackagename <- 1-stringdist(as.character(original[,6]),as.character(repackaged[,6]),method='cosine')
> summary(cosinePackagename)
   Min. 1st Qu.  Median    Mean 3rd Qu.    Max. 
0.06503 0.59481 0.70674 0.72651 0.91499 1.00000

>boxplot(cosinePackagename)


originalClean<-read.csv(file="D:/Ava/Empirical2018/originalAppsDetailsClean.csv", header=FALSE, sep=",")
> dim(originalClean)
[1] 2776   11

cosinePackagenameMatrix<- 1-stringdistmatrix(as.character(repackaged[,6]),as.character(originalClean[,6]),method='cosine')
> summary(cosinePackagenameMatrix)

 row<-rowSums(cosinePackagenameMatrix > 0.6)


stringdist("com.tekciz.thevoice","com.chinda_property.ecmobile")

originalpackageNameClean<-read.csv(file="D:/Ava/Empirical2018/originalPackagenameClean.csv", header=FALSE, sep=",")
repackagedpackageNameClean<-read.csv(file="D:/Ava/Empirical2018/repackagedPackageNameClean.csv", header=FALSE, sep=",")
originalpackageName<-read.csv(file="D:/Ava/Empirical2018/originalPackagename.csv", header=FALSE, sep=",")

cosinePackagenameCleanMatrix<- stringdistmatrix(as.character(repackagedpackageNameClean[,1]),as.character(originalpackageNameClean[,1]),method='cosine')

repackagedPackageNameClean
originalPackagenameClean

apkNames<-read.csv(file="D:/Ava/Empirical2018/apkNameOriginalRepackaged.csv", header=FALSE, sep=",")

cousineSim <- stringsim(as.character(apkNames[,1]),as.character(apkNames[,2]),method='cosine')
cousineSimP <- stringsim(as.character(originalpackageName[,1]),as.character(repackagedpackageNameClean[,1]),method='cosine')

x= matrix(,nrow=nrow(repackagedpackageNameClean),ncol=nrow(originalpackageNameClean))
for (i in 1:nrow(repackagedpackageNameClean)){
	for (j in 1:nrow(originalpackageNameClean)){

		x[i,j] <- stringsim(as.character(repackagedpackageNameClean[i,1]),as.character(originalpackageNameClean[j,1]),method='cosine')
	}

}
write.table(x,file="D:/Ava/Empirical2018/packagenameSimMatrix.csv",sep=",")

row= matrix(,nrow=nrow(repackagedpackageNameClean),ncol=10)
for (i in 1:nrow(repackagedpackageNameClean)){
	row[i,6]<-rowSums(x[i,] > 0.6)
}
 
###############################3
library(stringdist)
> originalpackageNameClean<-read.csv(file="D:/Ava/Empirical2018/originalPackagenameClean.csv", header=FALSE, sep=",")
> acts<-read.csv(file="D:/Ava/Empirical2018/repackagedHashIndex-withAds.csv", header=FALSE, sep=",")
> 
x= matrix(,nrow=1,ncol=nrow(originalpackageNameClean))
for(k in 0:15){
 	filename<-sprintf("D:/Ava/Empirical2018/packagenameSimMatrix%d.csv",k)
	for (i in 1:1000){
		for (j in 1:nrow(originalpackageNameClean)){
			x[1,j] <- stringsim(as.character(repackagedpackageNameClean[i+k*1000,1]),as.character(originalpackageNameClean[j,1]),method='cosine')
		}
		write.table(x,file=filename,sep=",", row.names = FALSE, col.names = FALSE, append=TRUE)
	}
 }
###################################

packageName<-read.csv(file="D:/Ava/Empirical2018/packagenameSimMatrix0.csv", header=FALSE, sep=",")
row= matrix(,nrow=1000,ncol=10)
for(k in 1:10){
for (i in 1:1000){
	row[i,k]<-rowSums(packageName[i,] > 0.1*k)
}
}
write.table(row, file="D:/Ava/Empirical2018/packagenameSimMatrix0Sum.csv", sep=",",  col.names = FALSE, row.names=FALSE)
##############################


> acts<-read.csv(file="D:/Ava/Empirical2018/repackagedHashIndex-window-all.csv", header=FALSE, sep=",")
> boxplot(acts[,2])
> summary(acts[,2])
   Min. 1st Qu.  Median    Mean 3rd Qu.    Max. 
   0.00    2.00   12.00   35.71   34.00  273.00 

> dim(acts)
[1] 15294     3

nameChange<-read.csv(file="D:/Ava/Empirical2018/NameChangeComplete1.csv", header=FALSE, sep=",")
names(nameChange)=c("a1","b1","c1","a2","b2","c2")

> sum(nameChange$c1=="None,"&nameChange$c2!="None,")#nameChange in reflection
[1] 24
> sum(nameChange$c1!="None,"&nameChange$c2!="None,")
[1] 543
> sum(nameChange$c1=="None,"&nameChange$c2=="None,")
[1] 14673
>  
> sum(nameChange$c1!="None,"&nameChange$c2=="None,")
[1] 53

>cor(as.numeric(nameChange[ ,3]),as.numeric(nameChange[ ,6]), method="spearman")
[1] 0.9314896
reflection<-read.csv(file="D:/Ava/Empirical2018/reflectionComplete.csv", header=FALSE, sep=",")
names(reflection)=c("a1","b1","c1","d1","a2","b2","c2","d2")
> cor(as.numeric(nameChange[ ,3]),as.numeric(reflection[ ,3]), method="spearman")
[1] -0.03907467
> cor(as.numeric(nameChange[ ,3]),as.numeric(reflection[ ,4]), method="spearman")
[1] -0.09720597
> cor(as.numeric(nameChange[ ,6]),as.numeric(reflection[ ,7]), method="spearman")
[1] -0.0465577
> cor(as.numeric(nameChange[ ,6]),as.numeric(reflection[ ,8]), method="spearman")
[1] -0.1468418
reflection$c1[reflection$c1=="None"] <- 0
reflection$c1[reflection$c1=="java.lang.reflect"] <- 1

nameChange$c1[nameChange$c1=="None,"]<-0
nameChange$c1[nameChange$c1=="NameObfuscation,"]<- 1

#pairs-serviceChanged-AllDetails
repackaged<-read.csv(file="D:/Ava/Classification2018/pairs-serviceChanged-AllDetails.csv", header=FALSE, sep=",")
dateRepackaged<-as.Date(as.character(repackaged[,7]),"%Y-%m-%d")
> d<-substring(dateRepackaged,0,4)
> xx<-barplot(table(d), ylim=range(0,200), ylab="Number of repackaged applications", xlab="Year")
> 
#####################
> d= as.Date("6/6/2014  7:40:56 PM", "%m/%d/%Y")
> d
[1] "2014-06-06"
> d1= as.Date("6/16/2014  7:40:56 PM", "%m/%d/%Y")
> d1
[1] "2014-06-16"
> as.numeric(d1-d)
[1] 10

repackaged<-read.csv(file="D:/Ava/Empirical2018/repackagedAppsDetailsF.csv", header=FALSE, sep=",")
original<-read.csv(file="D:/Ava/Empirical2018/originalAppsDetailsF.csv", header=FALSE, sep=",")
> dateRepackaged<-as.Date(as.character(repackaged[,4]),"%Y-%m-%d")
> dateOriginal<-as.Date(as.character(original[,4]),"%Y-%m-%d")
> days<-dateRepackaged-dateOriginal
write.csv(days, file="D:/Ava/Empirical2018/days-dex.csv")

>d<-substring(dateRepackaged,7,10)
> xx<-barplot(tail(table(d), n=5), ylim=range(0,11000), ylab="Number of repackaged applications", xlab="Year")
> text(x = xx, y = d1, label = d1, pos = 3, cex = 0.8, col = "red")


repackagedKaggle <- read.csv(file="C:/Ava/Docs/Empirical/repackagedAppsDetailsKaggle.csv", header=FALSE, sep=",")
downloadNumber<-table(repackagedKaggle[ ,3])
par(las=2, mar=c(12,4,2,2))
barplot(downloadNumber, ylim=range(0,140))
barplot(downloadNumber, ylim=range(0,140), xlab="", ylab="Number of repackaged applications")
title(xlab="Number of Downloads", mgp=c(5,1,0))
#boxplot(repackagedKaggle[ , 3], data=repackagedKaggle, outline=FALSE)
rate<-table(repackagedKaggle[ ,7])
boxplot(repackagedKaggle[ , 7], data=repackagedKaggle, outline=FALSE, ylab= "star-rating of repackaged application")
> summary(repackagedKaggle[ , 7])
   Min. 1st Qu.  Median    Mean 3rd Qu.    Max. 
  0.000   3.667   3.965   3.893   4.314   5.000 

I have these three strings:
letters <- "abc" 
numbers <- "123" 
mix <- "b1dd"
How can I check which one of these strings contains LETTERS ONLY or NUMBERS ONLY (in R)?
letters should only be TRUE in the LETTERS ONLY check
numbers should only be TRUE in the NUMBERS ONLY check
mix should be FALSE in every situation
I tried several approaches now but none of them really worked for me :( 
For example if I use
grepl("[:alnum:]*", "lett1ers") 
grepl("^[[:alnum:][:punct:][:space:]]*$", "lett1ers") 
> grepl("^[[:alnum:][:punct:][:space:]]*$", "Ali1? street") 
[1] TRUE
> grepl("^[[:alnum:][:punct:][:space:]]*$", "�?力跑车1")
[1] FALSE
oname<-grepl("^[[:alnum:][:punct:][:space:]]*$", apkNames[,1])
rname<-grepl("^[[:alnum:][:punct:][:space:]]*$", apkNames[,2])
sum(oname=="TRUE"&rname=="FALSE")
>340

sum(oname=="FALSE"&rname=="TRUE")
>365

> sum(oname=="FALSE")
[1] 3875
> sum(rname=="FALSE")
[1] 3850
>
> sum(oname=="FALSE"&rname=="FALSE")
[1] 3510




cousineSim[cousineSim <= 0.5]
#3296 out of 9179



