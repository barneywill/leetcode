import pandas as pd
from datetime import timedelta

def rising_temperature(weather: pd.DataFrame) -> pd.DataFrame:
    weather['previousDate'] = weather.recordDate + timedelta(days=-1)
    df = weather.join(weather.set_index('recordDate'), on=['previousDate'], how='left', rsuffix='_r')
    return df[df['temperature'] > df['temperature_r']][['id']]