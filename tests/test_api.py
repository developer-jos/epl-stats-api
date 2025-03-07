import requests
import time

API_URL = "http://localhost:8080/api/v1/player"
TOKEN = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IldRTFh3R0dnZUlWWTIwVVdJa3JkeCJ9.eyJpc3MiOiJodHRwczovL2Rldi11dHRsanBvMTI0bGNiYmsyLnVzLmF1dGgwLmNvbS8iLCJzdWIiOiI2cFBFcTZDT3ZwRUhROXNTNzMyM2habWp6Y0NUb3l6YkBjbGllbnRzIiwiYXVkIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwLyIsImlhdCI6MTc0MTIwNzMwNSwiZXhwIjoxNzQxMjkzNzA1LCJzY29wZSI6InJlYWRQbGF5ZXIgY3JlYXRlUGxheWVyIHVwZGF0ZVBsYXllciBkZWxldGVQbGF5ZXIiLCJndHkiOiJjbGllbnQtY3JlZGVudGlhbHMiLCJhenAiOiI2cFBFcTZDT3ZwRUhROXNTNzMyM2habWp6Y0NUb3l6YiIsInBlcm1pc3Npb25zIjpbInJlYWRQbGF5ZXIiLCJjcmVhdGVQbGF5ZXIiLCJ1cGRhdGVQbGF5ZXIiLCJkZWxldGVQbGF5ZXIiXX0.jXncZ1zGgoyQFjAwnrObQY_bGsnG5yeQA67jNtBBBu9BdEajM1EpBjWHtWZdrYoazRehIUaPQ_2WeLuB_RVk-E_BYu7KCHB-ALrZQXIErX-BXmooejeTnXnPwO4xtzid89LGXlHWndODfr_6kOtvnJMgN7ZYoZPfGx5JaZjkfKvadvo527iz2tgPyX2LCpBHD1FNiwz-ZgZjbHxjw113T8Ch0FdLzjMzs4ZESrUX2n0Fqph1Qb-0smNYY7PBZx6CDlqA79opmp7EFXzAdVxdiSEtnpdFrFIx9zXutz1Qa8B9tTKSuzG_LqMqO9_c0qL5CC_fFLiMvbryrXD3w3GYTQ"  # Replace with a valid token

# Wait for backend to start
time.sleep(5)

def test_get_players():
    headers = {"Authorization": TOKEN}
    response = requests.get(API_URL, headers=headers)
    assert response.status_code == 200 or response.status_code == 204  # Allow no-content
    if response.status_code == 200:
        assert "name" in response.json()[0]

def test_create_player():
    headers = {"Authorization": TOKEN, "Content-Type": "application/json"}
    payload = {"name": "Messi", "team": "Inter Miami"}
    response = requests.post(API_URL, json=payload, headers=headers)
    assert response.status_code == 201
    assert response.json()["name"] == "Messi"
