# API

- [API](#api)
  * [File](#file)
    + [Create database](#create-database)
      - [URL](#url)
      - [Parameters](#parameters)
    + [Open database](#open-database)
      - [URL](#url-1)
      - [Parameters](#parameters-1)
    + [Delete database](#delete-database)
      - [URL](#url-2)
      - [Parameters](#parameters-2)
    + [Rename database](#rename-database)
      - [URL](#url-3)
      - [Parameters](#parameters-3)
    + [Import GEDCOM file](#import-gedcom-file)
      - [URL](#url-4)
      - [Parameters](#parameters-4)
  * [Lists](#lists)
    + [Persons](#persons)
      - [URL](#url-5)
      - [Parameters](#parameters-5)
    + [Family](#family)
      - [URL](#url-6)
      - [Parameters](#parameters-6)
  * [Person](#person)
    + [Add person](#add-person)
      - [URL](#url-7)
      - [Parameters](#parameters-7)
    + [Delete person](#delete-person)
      - [URL](#url-8)
      - [Parameters](#parameters-8)
    + [Update person](#update-person)
      - [URL](#url-9)
      - [Parameters](#parameters-9)
    + [Search person](#search-person)
      - [URL](#url-10)
      - [Parameters](#parameters-10)

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
* Success Response
  - **Code:** 200
  - **Content:**
* Error Response
* Example Request
* Example Response
### Open database
Open a database file.
#### URL
GET /file/database/open
#### Parameters
|  Name   | Type |  In  | Required | Description |
|  ----   | ---- | ---- |   ----   |    ----     |
| database_name |String| query |required| The name of the database |
| database_path |String|query|required|The path of the database file|
* Success Response
* Success Response
  - **Code:** 200
  - **Content:**
* Error Response
* Example Request
* Example Response

### Delete database
Delete a database file.
#### URL
POST /file/database/delete
#### Parameters
|  Name   | Type |  In  | Required | Description |
|  ----   | ---- | ---- |   ----   |    ----     |
| database_name |String| query |required| The name of the database |
| database_path |String|query|required|The path of the database file|
* Success Response
  - **Code:** 200
  - **Content:**
* Error Response
* Example Request
* Example Response

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
* Success Response
  - **Code:** 200
  - **Content:**
* Error Response
* Example Request
* Example Response

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
## Lists
### Persons
Return all persons in the database
#### URL
POST /lists/persons
#### Parameters
**None**
* Success Response
  - **Code:** 200
  - **Content:**{Persons}
* Error Response
* Example Request
* Example Response

### Family
Return family members.
#### URL
POST /lists/family
#### Parameters
**None**
* Success Response
  - **Code:** 200
  - **Content:**{Family}
* Error Response
* Example Request
* Example Response

## Person
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

### Search person
Find a person by first name and last name.
#### URL
GET /person/search
#### Parameters
|  Name   | Type |  In  | Required | Description |
|  ----   | ---- | ---- |   ----   |    ----     |
| first_name | String |query |required| The first name of the person |
| last_name | String |query|required|The last name of the person|
* Success Response
  - **Code:** 200
  - **Content:**{Person}
* Error Response
* Example Request
* Example Response
