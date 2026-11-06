# assignment-3-crudapi
# Pokémon Trainer API

A RESTful CRUD API for fictional characters from the Assignment 2 website. In this case, it's Pokémon Trainers. (Pokémon is owned by The Pokémon Company. I do not claim ownership.)

## Entity Attributes

- characterId
- Name
- Description
- Type (The type of Pokémon they use)
- Strategy - A short blurb from the character i.e. Trainer's Eyes from Gen 3.

## Endpoints

Base path: `/api/characters`

| Method | Path | Description | Success |
|--------|------|-------------|---------|
| GET | `/api/characters` | List all Trainers | 200 |
| GET | `/api/characters/{id}` | Get one Trainer by ID | 200 |
| POST | `/api/characters` | Add Trainer | 201 |
| PUT | `/api/characters/{id}` | Replace a Trainer's fields | 200 |
| DELETE | `/api/characters/{id}` | Delete a Trainer | 204 |
| GET | `/api/characters?type=` | Filter by one category | 200 |
| GET | `/api/characters?name=` | Search by name (partial, case-insensitive) | 200 |

### Example request

```http
POST /api/plants
Content-Type: application/json

{
  "description": "TRAINER on ROUTE 109.",
  "name": "TUBER LOLA",
  "strategy": "I'm going to try hard!",
  "type": "WATER"
}
```

### Link to deployed API on Render

https://assignment-3-crudapi.onrender.com/api/characters

NOTICE: Free Render services sleep when idle, so the first request can take up to a minute.
