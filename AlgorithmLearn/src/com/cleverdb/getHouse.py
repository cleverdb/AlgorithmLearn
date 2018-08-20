# -*- coding: utf-8 -*-
import gzip
import requests
import ssl
import json
import urllib.request
from io import StringIO
from http import cookiejar

filename = 'cookie.txt'

mockCookies = "aliyungf_tc=AQAAACtDQVyIwQMAm5EryvP7s7c8pbj8; PHPSESSID=9n95tu8qvm9m9h28se4605dds6; last_env=g2"

header = {
    'Accept':'*/*',
    'Accept-Encoding':'gzip, deflate, br',
    'Accept-Language':'zh-CN,zh;q=0.9',
    'Connection':'keep-alive',
    'Content-Length':'84',
    'Content-Type':'application/x-www-form-urlencoded;charset=UTF-8',
    #'Cookie': 'aliyungf_tc=AQAAACtDQVyIwQMAm5EryvP7s7c8pbj8; PHPSESSID=gvh9r450fivarulht3ccq4kob3; last_env=g2',
    'Host':'ztcwx.myscrm.cn',
    'Origin':'https://ztcwx.myscrm.cn',
    'Referer':'https://ztcwx.myscrm.cn/page/login.html?activityId=3945&token=awceat1503627283&url=https%3A%2F%2Fztcwx.myscrm.cn%2Fpage%2Factivity.html%3Ftoken%3Dawceat1503627283%26activityId%3D3945',
    'User-Agent':'Mozilla/5.0 (Linux; U; Android 4.1.2; zh-cn; Chitanda/Akari) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30 Micromessage/6.0.0.58_r884092.501 NetType/WIFI',
    'X-Requested-With':'XMLHttpRequest',
}
# session代表某一次连接
houseSession = requests.session()
#原始的session.cookies 没有save()方法
houseSession.cookies = cookiejar.LWPCookieJar(filename=filename)


def isLogin():
    requestUrl = "https://ztcwx.myscrm.cn/index.php?r=choose-room-activity/confirm-login&token=awceat1503627283&activityId=3945";
    #需要带header
    #没有登陆会重定向，返回200，所以不允许重定向，
    data = 'verify=False&mobile=15689562563&idCardNo=42125199506384562'
    resp = houseSession.post(requestUrl, data,headers=header,verify=False)
    #houseSession.cookies.save(ignore_discard=True)

    print(resp.cookies.__dict__)
    print('login status'+ resp.text)
    if (resp.status_code == 200):
        return True
    else:
        return False

def login():
    url = 'https://ztcwx.myscrm.cn/index.php?r=choose-room-activity/confirm-login&token=awceat1503627283&activityId=3945'
    header = {
    'Accept':'*/*',
    'Accept-Encoding':'gzip, deflate, br',
    'Accept-Language':'zh-CN,zh;q=0.9',
    'Connection':'keep-alive',
    'Content-Length':'84',
    'Content-Type':'application/x-www-form-urlencoded;charset=UTF-8',
    'Cookie': 'aliyungf_tc=AQAAACtDQVyIwQMAm5EryvP7s7c8pbj8; PHPSESSID=gvh9r450fivarulht3ccq4kob3; last_env=g2',
    'Host':'ztcwx.myscrm.cn',
    'Origin':'https://ztcwx.myscrm.cn',
    'Referer':'https://ztcwx.myscrm.cn/page/login.html?activityId=3945&token=awceat1503627283&url=https%3A%2F%2Fztcwx.myscrm.cn%2Fpage%2Factivity.html%3Ftoken%3Dawceat1503627283%26activityId%3D3945',
    'User-Agent':'Mozilla/5.0 (Linux; U; Android 4.1.2; zh-cn; Chitanda/Akari) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30 Micromessage/6.0.0.58_r884092.501 NetType/WIFI',
    'X-Requested-With':'XMLHttpRequest',
    }
    data = 'verify=False&mobile=15689562563&idCardNo=42125199506384562'
    ssl._create_default_https_context = ssl._create_unverified_context
    loginResult = houseSession.post(url, data,headers=header,verify=False)
    #ignore_discard=True
    houseSession.cookies.save()
    print("text =="+loginResult.text)
    if loginResult.status_code == 200 :
        return True
    else:
        return False

def startBuyHouse():
    return True



if  __name__ == "__main__":
    houseSession.cookies.load(ignore_discard=True)
    #login()
    isLogin()
    #开始买房
    startBuyHouse()

