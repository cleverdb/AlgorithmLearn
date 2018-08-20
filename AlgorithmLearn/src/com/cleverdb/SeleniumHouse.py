# -*- coding: utf-8 -*-
from selenium import webdriver
import requests
import os,time

from selenium.common.exceptions import NoSuchElementException, ElementNotVisibleException

chromedriver = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe"
loginFlag = True
loginNum = 1
#房间号排序
housesList = [1205, 1206, 1308]
openHouse = False
#os.environ["webdriver.chrome.driver"] = chromedriver

def initRequest():
    chromeOpt = webdriver.ChromeOptions()
    chromeOpt.add_argument('--user-agent=Mozilla/5.0 (Linux; U; Android 4.1.2; zh-cn; Chitanda/Akari) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30 Micromessage/6.0.0.58_r884092.501 NetType/WIFI')
    driver = webdriver.Chrome(executable_path=chromedriver,chrome_options=chromeOpt)
    driver.maximize_window()
    driver.get("https://ztcwx.myscrm.cn")
    driver.add_cookie({'name':'aliyungf_tc','value':"AQAAACtDQVyIwQMAm5EryvP7s7c8pbj8", 'path':"/", 'domain':"ztcwx.myscrm.cn"})
    driver.add_cookie({'name':'PHPSESSID','value':"imnf4b0dhvnc1j72st0f4ptie4", 'path':"/", 'domain':"ztcwx.myscrm.cn"})
    driver.add_cookie({'name':'last_env','value':'g2', 'path':"/", 'domain':"ztcwx.myscrm.cn"})
    driver.get("https://ztcwx.myscrm.cn/page/login.html?activityId=3945&token=awceat1503627283&url=https%3A%2F%2Fztcwx.myscrm.cn%2Fpage%2Factivity.html%3Ftoken%3Dawceat1503627283%26activityId%3D3945")
    #time.sleep(2)
    while(loginFlag):
        login(driver)
    print("---------------ok------------")

# 登陆
def login(_driver):
    try:
        telephone = _driver.find_element_by_id("telephone")
        telephone.clear()
        telephone.send_keys(15356268964)
        id_card = _driver.find_element_by_id("id_card")
        id_card.clear()
        id_card.send_keys(421025199208042658)
        _driver.execute_script("$('#login').click()")
        #driver.find_element_by_xpath("//*[@id=\"login\"]").click()
        if loginNum < 2 :
            _driver.find_element_by_id("readProtocol").click()
            _driver.find_element_by_xpath("//*[@id=\"protocolTip\"]/div/div[3]/div[2]").click()
        loginFlag = False
        ++ loginNum
    except NoSuchElementException as e:
        print(e.msg)
        print("NoSuchElementException login error ,will login again!")
    except ElementNotVisibleException as e:
        print(e.msg)
        print("ElementNotVisibleException login error ,will login again!")
    except Exception as e:
        print(e.msg)

def  getHouses(_driver):
    housesElement =[]
    #获取选定的房间号元素
    for houseNum in housesList:
        # TODO
        housesElement.append(_driver.find_element_by_id(houseNum))
    #循环，当未抛出异常，说明进入某一个房间，退出循环，进入确定操作
    while openHouse == False:
        for element in  housesElement:
            try:
                element.click()
                openHouse = True
                break
            except ElementNotVisibleException as e:
                print(e.msg)
                print("ElementNotVisibleException----"+element)
    time.sleep(10)

if __name__ == "__main__":
    initRequest()
    time.sleep(200)


