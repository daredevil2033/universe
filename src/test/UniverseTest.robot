*** Settings ***
Library  SeleniumLibrary

*** Variables ***
${BROWSER}   chrome
${SELSPEED}  0.1

*** Test Cases ***
robotframework-testing_selenium
    [Setup]  Run Keywords  Open Browser  http://localhost:7000/  ${BROWSER}
    ...              AND   Set Selenium Speed  ${SELSPEED}
    #Реєстрація користувачів
    click    css=.hero__button
    type    id=sign-up__first-name    FirstName
    type    id=sign-up__last-name    LastName
    type    id=sign-up__email    test@gmail.com
    type    id=sign-up__password    F6dvj!FGE9MYR
    type    id=sign-up__confirm-password    F6dvj!FGE9MYR
    click    css=.form__button
    click    css=.alert__button
    #Зареєстровані користувачі можуть створювати записи
    click    css=.header__link
    editContent    css=.post-form__title    Post Title
    editContent    css=.post-form__description    Post Body
    click    css=.post-form__button:nth-child(2)
    click    css=.alert__button
    #Користувачі можуть залишати коментарі до записів
    click    css=.card:nth-child(1) > .card__button
    type    css=.comment-form__textarea    Post Comment
    click    css=.comment-form__button:nth-child(1)
    #У користувача є профайл
    open    http://localhost:7000/account
    [Teardown]  Close Browser

*** Keywords ***
open
    [Arguments]    ${element}
    Go To          ${element}

click
    [Arguments]    ${element}
    Click Element  ${element}

sendKeys
    [Arguments]    ${element}    ${value}
    Press Keys     ${element}    ${value}

submit
    [Arguments]    ${element}
    Submit Form    ${element}

type
    [Arguments]    ${element}    ${value}
    Input Text     ${element}    ${value}

editContent
    [Arguments]    ${element}    ${value}
    Input Text     ${element}    ${value}
#not in Selenium IDE \/
selectByLabel
    [Arguments]        ${element}  ${value}
    Select From List By Label   ${element}  ${value}

selectByValue
    [Arguments]        ${element}  ${value}
    Select From List By Value   ${element}  ${value}

selectByIndex
    [Arguments]        ${element}  ${value}
    Select From List By Index   ${element}  ${value}

deleteAllCookies
    Delete All Cookies

deleteCookie
    [Arguments]    ${name}
    Delete Cookie  ${name}

mouseOver
    [Arguments]    ${element}
    Mouse Over     ${element}
#not in Selenium IDE /\
verifyValue
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

verifyText
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

verifyElementPresent
    [Arguments]                  ${element}
    Page Should Contain Element  ${element}

verifyVisible
    [Arguments]                  ${element}
    Page Should Contain Element  ${element}

verifyTitle
    [Arguments]                  ${title}
    Title Should Be              ${title}

verifyTable
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

assertConfirmation
    [Arguments]                  ${value}
    Alert Should Be Present      ${value}

assertText
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

assertValue
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

assertElementPresent
    [Arguments]                  ${element}
    Page Should Contain Element  ${element}

assertVisible
    [Arguments]                  ${element}
    Page Should Contain Element  ${element}

assertTitle
    [Arguments]                  ${title}
    Title Should Be              ${title}

assertTable
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

waitForText
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

waitForValue
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

waitForElementPresent
    [Arguments]                  ${element}
    Page Should Contain Element  ${element}

waitForVisible
    [Arguments]                  ${element}
    Page Should Contain Element  ${element}

waitForTitle
    [Arguments]                  ${title}
    Title Should Be              ${title}

waitForTable
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

doubleClick
    [Arguments]           ${element}
    Double Click Element  ${element}

goBack
    Go Back

runScript
    [Arguments]         ${code}
    Execute Javascript  ${code}

setSpeed
    [Arguments]           ${value}
    Set Selenium Timeout  ${value}

verifyAlert
    [Arguments]              ${value}
    Alert Should Be Present  ${value}
