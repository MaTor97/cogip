
# Cogit

A brief description of what this project does and who it's for



# API Reference

## Invoice

#### Create a new invoice

```http
  POST /api/invoice/new
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `auth_key` | `string` | **Required**. Your auth key |
| `ref` | `string` | **Required**. reference of the invoice |
| `dueDate` | `string` | **Required**. Due date of the invoice |
| `companyID` | `string` | **Required**. the ID of the company |

#### Update an invoice

```http
  patch /api/invoice/update
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `auth_key` | `string` | **Required**. Your auth key |
| `id` | `int` | ID of the invoice to update |
| `ref` | `string` | reference of the invoice |
| `companyID` | `string` | the ID of the company |

#### delete an invoice

```http
  DEL /api/invoice/delete
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `auth_key` | `string` | **Required**. Your auth key |
| `id` | `int` | ID of the invoice to delete |


#### The list of the last 5 invoices, ordered by date

```http
  GET /api/invoice/last5
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `auth_key` | `string` | **Required**. Your auth key |

```
[{
    id: 7,
    ref: SQSDH256FDSH,
    id_company: 3,
    created_at: 2025-01-24,
    updated_at: 2025-01-26,
},...]

```

## Contact

#### Create a new contact

```http
  GET /api/contact/new
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `auth_key`      | `string` | **Required**. Your auth key |
| `name` | `string` | **Required**. contact name |
| `company_id` | `int` | **Required**. ID of the company of the contact |
| `email` | `string` | **Required**. contact email |
| `phone` | `string` | **Required**. contact phone |

#### Update a contact information

```http
  PATCH /api/contact/update
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `auth_key`      | `string` | **Required**. Your auth key |
| `id`      | `int` | **Required**. Id of the contact to update |
| `name` | `string` | updated name |
| `company_id` | `int` | updated ID of the company of the contact |
| `email` | `string` | updated email |
| `phone`| `string` | updated phone |


#### Delete a contact

```http
  DEL /api/contact/delete
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `auth_key`      | `string` | **Required**. Your auth key |
| `id`      | `int` | **Required**. Id of the contact to delete |

#### The list of the last 5 contacts encoded in the database

```http
  GET /api/contact/last5
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `auth_key`      | `string` | **Required**. Your auth key |

```
[{
    id: 7,
    name: Peter Gregory,
    company_id: 3,
    email: petergreg@gmail.com
    created_at: 2025-01-24,
    updated_at: 2025-01-26,
},...]

```

## Company

#### Create a new company

```http
  GET /api/company/new
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `auth_key`      | `string` | **Required**. Your auth key |
| `name` | `string` | **Required**. contact name |
| `type_id` | `int` | **Required**. type of the company 0 for supplier / 1 for client |
| `country` | `int` | **Required**. Country of the company |
| `tva` | `string` | **Required**. TVA of the company |

#### Update a company information

```http
  PATCH /api/company/update
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `auth_key`      | `string` | **Required**. Your auth key |
| `id` | `int` | **Required**. ID of the company
| `name` | `string` | updated contact name |
| `type_id` | `int` | updated type of the company 0 for supplier / 1 for client |
| `country` | `int` | updated Country of the company |
| `tva` | `string` | updated TVA of the company |


#### Delete a company

```http
  DEL /api/company/delete
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `auth_key`      | `string` | **Required**. Your auth key |
| `id`      | `int` | **Required**. Id of the company to delete |

#### The list of the last 5 companies encoded in the database

```http
  GET /api/company/last5
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `auth_key`      | `string` | **Required**. Your auth key |

```
[{
    id: 7,
    name: Dunder Muffin,
    type_id: 3,
    country: Belgium,
    tva: BE0987 876 787
    created_at: 2025-01-24,
    updated_at: 2025-01-26,
},...]

```

