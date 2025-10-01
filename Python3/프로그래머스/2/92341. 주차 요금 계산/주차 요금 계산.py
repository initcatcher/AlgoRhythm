from collections import defaultdict

def parse_time_to_minutes(time):
    hours, minutes = map(int, time.split(':'))
    return hours * 60 + minutes

def calculate_parking_fee(fees, time):
    base_time, base_fee, unit_time, unit_fee = fees
    
    time -= base_time
    extra_units = 0
    if time > 0:
        extra_units = time // unit_time
        if time % unit_time:
            extra_units += 1
    
    return base_fee + extra_units * unit_fee

def solution(fees, records):
    base_time, base_fee, unit_time, unit_fee = fees
    
    entry_times = {}
    total_parking_times = defaultdict(int)
    
    for record in records:
        time_str, car_number, status = record.split()
        
        time_in_minutes = parse_time_to_minutes(time_str)
        if status == 'IN':
            entry_times[car_number] = time_in_minutes
        else:
            total_parking_times[car_number] += time_in_minutes - entry_times[car_number]
            entry_times[car_number] = None
    
    midnight = parse_time_to_minutes('23:59')
    for car_number, entry_time in entry_times.items():
        if entry_time is not None:
            total_parking_times[car_number] += midnight - entry_time
    
    
    return [calculate_parking_fee(fees, total_parking_times[car_number])
           for car_number in sorted(total_parking_times.keys())]