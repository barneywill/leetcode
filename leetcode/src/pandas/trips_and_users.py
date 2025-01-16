import pandas as pd

def trips_and_users(trips: pd.DataFrame, users: pd.DataFrame) -> pd.DataFrame:
    trips = trips[(trips['request_at'] >= '2013-10-01') & (trips['request_at'] <= '2013-10-03')]
    users = users[users.banned == 'No']
    df = trips.join(users.set_index('users_id'), on=['driver_id'], how='inner', rsuffix='_driver') \
        .join(users.set_index('users_id'), on=['client_id'], how='inner', rsuffix='_client')
    df = df[['request_at', 'status']]
    df_count = df.groupby(['request_at']).size().reset_index(name='count')
    df_cancel_count = df[df.status.str.startswith('cancelled')].groupby(['request_at']).size().reset_index(name='cancel_count')
    df_result = df_count.join(df_cancel_count.set_index('request_at'), on=['request_at'], how='left')
    df_result['cancel_count'] = df_result['cancel_count'].fillna(0)
    df_result['Cancellation Rate'] = round(df_result['cancel_count'] / df_result['count'], 2)
    df_result.rename(columns={'request_at':'Day'}, inplace=True)
    return df_result[['Day', 'Cancellation Rate']]