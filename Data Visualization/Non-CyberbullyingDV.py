# Data Visualization for Non-cyberbullying content

import matplotlib.pyplot as plot 
  
# labels are defined 
dataLabels = ['Non-Cyberbullying ', 'Cyberbullying '] 
  
# Each label's area covered 
partition = [9.59,0.41] 
  
# Colours for labels 
col = ['yellow', 'red'] 
  
# Create Pie chart
plot.pie(partition, labels = dataLabels, colors=col,  
        startangle=10, shadow = True, explode = (0, 0.1), 
        radius = 1.2, autopct = '%1.2f%%') 
  
# Display the title and legend
plot.title("Non-Cyberbullying Data Visualization")
plot.legend(bbox_to_anchor=(1, 1), loc=2, borderaxespad=2) 
  
# Display the chart 
plot.show() 
