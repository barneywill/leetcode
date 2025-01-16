import pandas as pd

def combine_two_tables(person: pd.DataFrame, address: pd.DataFrame) -> pd.DataFrame:
    return person.join(address.set_index('personId'), on=['personId'], how='left', lsuffix='_l', rsuffix='_r')[['firstName', 'lastName', 'city', 'state']]