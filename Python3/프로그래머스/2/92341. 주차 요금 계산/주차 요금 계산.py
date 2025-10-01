from collections import defaultdict

def cal_time(time):
    h,m = map(int, time.split(':'))
    return h*60 + m

def cal_cost(fees, time):
    basic_time, basic_fee, time_barometer, time_fee = fees
    
    time -= basic_time
    baro = 0
    if time > 0:
        baro = time//time_barometer
        if time%time_barometer:
            baro += 1
    
    return basic_fee + baro * time_fee

def solution(fees, records):
    
    basic_time, basic_fee, time_deli, time_fee = fees
    
    table = {}
    answer = defaultdict(int)
    for record in records:
        time, car, in_out = record.split()
        
        time_cal = cal_time(time)
        if in_out == 'IN':
            table[car] = time_cal
        else:
            answer[car] += time_cal - table[car]
            table[car] = -1
    midnight = cal_time('23:59')
    for car,time in table.items():
        if time == -1:
            continue
        answer[car] += midnight - time
    
    cost = []
    for car in sorted(answer.keys()):
        cost.append(cal_cost(fees,answer[car]))

    return cost