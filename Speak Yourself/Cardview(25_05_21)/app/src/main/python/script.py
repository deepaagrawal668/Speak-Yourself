# import speech_recognition as sr
# from gingerit.gingerit import GingerIt
# #r=sr.Recognizer()
# string = ""
# c = 1
# parser = GingerIt()
# while True:
#     r = sr.Recognizer()
#     with sr.Microphone() as source:
#         if c == 1:
#             print("Start")
#             c = 2
#         audio = r.listen(source)
#         query = r.recognize_google(audio)
#         print(query)
#         string = string+", "+query
#     if ("thank you" or "thankyou" in query):
#         break

# a = parser.parse(string)['corrections']
# a1 = []
# for b in a:
#     if ((b['text']).upper() != (b['correct']).upper()) and (b['definition'] != 'Accept comma addition') and ('?' not in b['correct']) and ('.' not in b['correct']) and (',' not in b['correct']) and ('!' not in b['correct']):
#        a1.append(b)
# return a1
# word_count = string.count(" ")
# filler_count = 0
# fillers = ["like", "what we can say", "and", "i mean", "you know", "anyway", "all right","allright", "whatever", "what ever","what-ever", "youknow", "imean", "so", "basically", "actually", "right", "ah", "uh","um"]
# for s in fillers:
#         filler_count += string.count(s)
# print("Filler Count = ", filler_count)
# print("Word Count = ", word_count)
# file = open("file.txt", "w")
# file.write(string)
# file.close()
#Filler_count, word_count, 

return "Hello"
