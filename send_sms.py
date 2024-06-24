import os
from twilio.rest import Client

def send_sms(to, message):
    account_sid = 'AC3347ee37a65a642c3058d41d1ba8d898'
    auth_token = '90a55ec2d8ff31aa5f3bfdb08914f4a5'
    client = Client(account_sid, auth_token)

    message = client.messages.create(
        body=message,
        from_='+51912609733',
        to=to
    )

if __name__ == "__main__":
    to = os.getenv('SMS_TO')
    message = os.getenv('SMS_MESSAGE')
    send_sms(to, message)
