# API

- [File](#file)
  * [Create database](#create-database)
    + [URL](#url)
    + [Parameters](#parameters)
  * [Open database](#open-database)
    + [URL](#url-1)
    + [Parameters](#parameters-1)
  * [Delete database](#delete-database)
    + [URL](#url-2)
    + [Parameters](#parameters-2)
  * [Rename database](#rename-database)
    + [URL](#url-3)
    + [Parameters](#parameters-3)
  * [Import GEDCOM file](#import-gedcom-file)
    + [URL](#url-4)
    + [Parameters](#parameters-4)
- [Family](#family)
  * [Family Tree](#family-tree)
    + [URL](#url-5)
    + [Parameters](#parameters-5)
- [Person](#person)
  * [List persons](#list-persons)
    + [URL](#url-6)
    + [Parameters](#parameters-6)
  * [Add person](#add-person)
    + [URL](#url-7)
    + [Parameters](#parameters-7)
  * [Delete person](#delete-person)
    + [URL](#url-8)
    + [Parameters](#parameters-8)
  * [Update person](#update-person)
    + [URL](#url-9)
    + [Parameters](#parameters-9)
  * [Search person by full name](#search-person-by-full-name)
    + [URL](#url-10)
    + [Parameters](#parameters-10)
  * [Search person by id](#search-person-by-id)
    + [URL](#url-11)
    + [Parameters](#parameters-11)

## File
### Create database
Create a new sqlite database file.
#### URL
POST /file/database/create
#### Parameters
|  Name   | Type |  In  | Required | Description |
|  ----   | ---- | ---- |   ----   |    ----     |
| database_name |String| query |required| The name of the database |
| database_path |String|query|required|The path of the database file|
* Example Request
```shell
http://3.9.172.108:8090/api/file/database/create?database_name=test&database_path=%2Fhome%2Fec2-user%2FFamilyFacts%2Fsqlite%2F
```
* Example Response
```json
{
  "success": true,
  "code": 200,
  "msg": "Success",
  "data": null
}
```
### Open database
Open a database file.
#### URL
GET /file/database/open
#### Parameters
|  Name   | Type |  In  | Required | Description |
|  ----   | ---- | ---- |   ----   |    ----     |
| database_name |String| query |required| The name of the database |
| database_path |String|query|required|The path of the database file|
* Example Request
```shell
http://3.9.172.108:8090/api/file/database/open?database_name=test&database_path=%2Fhome%2Fec2-user%2FFamilyFacts%2Fsqlite%2F
```
* Example Response
```json
{
  "success": true,
  "code": 200,
  "msg": "Success",
  "data": null
}
```

### Delete database
Delete a database file.
#### URL
POST /file/database/delete
#### Parameters
|  Name   | Type |  In  | Required | Description |
|  ----   | ---- | ---- |   ----   |    ----     |
| database_name |String| query |required| The name of the database |
| database_path |String|query|required|The path of the database file|
* Example Request
```shell
http://3.9.172.108:8090/api/file/database/delete?database_name=test&database_path=%2Fhome%2Fec2-user%2FFamilyFacts%2Fsqlite%2F
```
* Example Response
```json
{
  "success": true,
  "code": 200,
  "msg": "Success",
  "data": null
}
```

### Rename database
Rename a database file.
#### URL
POST /file/database/rename
#### Parameters
|  Name   | Type |  In  | Required | Description |
|  ----   | ---- | ---- |   ----   |    ----     |
| old_name | String | query |required| The old name of the database |
| new_name | String | query |required| The new name of the database |
| database_path |String|query|required|The path of the database file|
* Example Request
```shell
http://3.9.172.108:8090/api/file/database/rename?old_name=test&new_name=demo&database_path=%2Fhome%2Fec2-user%2FFamilyFacts%2Fsqlite%2F
```
* Example Response
```json
{
  "success": true,
  "code": 200,
  "msg": "Success",
  "data": null
}
```

### Import GEDCOM file
Import a GEDCOM file and parse it into a new database file.
#### URL
POST /file/gedcom/import
#### Parameters
|  Name   | Type |  In  | Required | Description |
|  ----   | ---- | ---- |   ----   |    ----     |
| file_name | String | query |required| The name of the gedcom file |
| file_path | String | query|required|The path of the gedcom file|
* Success Response
  - **Code:** 200
  - **Content:**
* Error Response
* Example Request
* Example Response

## Family
### Family Tree
Return one person's family tree.
#### URL
GET /api/family/tree/{person_id}
#### Parameters
|  Name   | Type |  In  | Required | Description |
|  ----   | ---- | ---- |   ----   |    ----     |
| person_id | Integer |path |required| The id of the person |
```shell
http://3.9.172.108:8090/api/family/tree/7
```
* Example Response
```json
{
  "success": true,
  "code": 200,
  "msg": "Success",
  "data": {
    "personId": 7,
    "father": {
      "personId": 6,
      "father": null,
      "mother": null,
      "fullName": {
        "nameId": 6,
        "ownerId": 6,
        "surname": "Henning",
        "given": "Johann Carl Ludewig",
        "prefix": "",
        "suffix": "",
        "nickname": "",
        "nameType": 0,
        "date": ".",
        "sortDate": -1,
        "isPrimary": 1,
        "isPrivate": 0,
        "proof": 0,
        "editDate": 0,
        "sentence": "",
        "note": "",
        "birthYear": 1805,
        "deathYear": 1874
      }
    },
    "mother": {
      "personId": 11,
      "father": null,
      "mother": null,
      "fullName": {
        "nameId": 11,
        "ownerId": 11,
        "surname": "",
        "given": "Living",
        "prefix": "",
        "suffix": "",
        "nickname": "",
        "nameType": 0,
        "date": ".",
        "sortDate": -1,
        "isPrimary": 1,
        "isPrivate": 0,
        "proof": 0,
        "editDate": 0,
        "sentence": "",
        "note": "",
        "birthYear": 0,
        "deathYear": 0
      }
    },
    "fullName": {
      "nameId": 7,
      "ownerId": 7,
      "surname": "Henning",
      "given": "Wilhelm Friederich",
      "prefix": "",
      "suffix": "",
      "nickname": "",
      "nameType": 0,
      "date": ".",
      "sortDate": -1,
      "isPrimary": 1,
      "isPrivate": 0,
      "proof": 0,
      "editDate": 0,
      "sentence": "",
      "note": "",
      "birthYear": 1853,
      "deathYear": 1915
    }
  }
}
```

## Person
### List persons
Return all persons in the database
#### URL
GET /api/person/list
#### Parameters
**None**
* Example Request
```shell
http://3.9.172.108:8090/api/person/list
```
* Example Response
```json
{
  "success": true,
  "code": 200,
  "msg": "Success",
  "data": [
    {
      "personId": 1,
      "uniqueId": "92D5A0FA583B4E5382B47F61EE9669CF07A3",
      "sex": 0,
      "editDate": 43357,
      "parentId": 45,
      "spouseId": 1,
      "color": 0,
      "relate1": 0,
      "relate2": 0,
      "flags": 0,
      "living": 0,
      "isPrivate": 0,
      "proof": 0,
      "bookmark": 0,
      "note": ""
    }
  ]
}
```
### Add person
Add a new person.
#### URL
POST /person/create
#### Parameters
|  Name   | Type |  In  | Required | Description |
|  ----   | ---- | ---- |   ----   |    ----     |
| first_name | String |body |required| The first name of the person |
| last_name | String |body|required|The last name of the person|
| sex | String |body|required|The sex of the person|
| parent_id | Integer |body|optional|Parents of the person|
| spouse_id | Integer |body|optional|The spouse of the person|
* Success Response
  - **Code:** 200
  - **Content:**
* Error Response
* Example Request
* Example Response

### Delete person
Delele a person.
#### URL
POST /person/delete
#### Parameters
|  Name   | Type |  In  | Required | Description |
|  ----   | ---- | ---- |   ----   |    ----     |
| first_name | String |query |required| The first name of the person |
| last_name | String |query|required|The last name of the person|
* Success Response
  - **Code:** 200
  - **Content:**
* Error Response
* Example Request
* Example Response

### Update person
Update a person.
#### URL
POST /person/update
#### Parameters
|  Name   | Type |  In  | Required | Description |
|  ----   | ---- | ---- |   ----   |    ----     |
| first_name | String |query |required| The first name of the person |
| last_name | String |query|required|The last name of the person|
* Success Response
  - **Code:** 200
  - **Content:**
* Error Response
* Example Request
* Example Response

### Search person by full name
Find a person by first name and last name.
#### URL
GET /api/person/search
#### Parameters
|  Name   | Type |  In  | Required | Description |
|  ----   | ---- | ---- |   ----   |    ----     |
| first_name | String |query |required| The first name of the person |
| last_name | String |query|required|The last name of the person|
* Example Request
```shell
http://3.9.172.108:8090/api/person/search?first_name=Wilhelm%20Friederich&last_name=Henning
```
* Example Response
```json
{
  "success": true,
  "code": 200,
  "msg": "Success",
  "data": {
    "personId": 7,
    "uniqueId": "6B810C551EB64501A2515B6B93221F5E52FB",
    "sex": 0,
    "editDate": 43351,
    "parentId": 6,
    "spouseId": 7,
    "color": 0,
    "relate1": 0,
    "relate2": 0,
    "flags": 0,
    "living": 0,
    "isPrivate": 0,
    "proof": 0,
    "bookmark": 0,
    "note": ""
  }
}
```
### Search person by id
Find a person by person id.
#### URL
GET /api/person/search/{person_id}
#### Parameters
|  Name   | Type |  In  | Required | Description |
|  ----   | ---- | ---- |   ----   |    ----     |
| person_id | Integer |path |required| The id of the person |
* Example Request
```shell
http://3.9.172.108:8090/api/person/search/7
```
* Example Response
```json
{
  "success": true,
  "code": 200,
  "msg": "Success",
  "data": {
    "personId": 7,
    "uniqueId": "6B810C551EB64501A2515B6B93221F5E52FB",
    "sex": 0,
    "editDate": 43351,
    "parentId": 6,
    "spouseId": 7,
    "color": 0,
    "relate1": 0,
    "relate2": 0,
    "flags": 0,
    "living": 0,
    "isPrivate": 0,
    "proof": 0,
    "bookmark": 0,
    "note": ""
  }
}
```
